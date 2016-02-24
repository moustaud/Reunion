package grus

class MeetingController {
    
    def index() { }
    def add(){
    	if(request.method == 'POST'){
    	   
            def facilitator = User.findById(params.facilitator)
            // create de process from the processModel
            // get the modelProcess
            def processModel = ProcessModel.findById(params.processModel)
            def process = new Process(modelProcess : params.processModel)
            process.save(flush : true)

            def phaseNumber = 0
            def itemsPhases = [:]
            // for each modelPhase in modelProcess
            
            processModel.phasesOfModel.each{key,value ->
                // create phase with the same name of model
                def modelPhaseObject = PhaseModel.findById(value)
                
                def phase = new Phase(phaseName:modelPhaseObject.modelPhaseName,process : process.id)
                phase.save(flush : true)
                def tools = [:]
                modelPhaseObject.toolsName.each{index,tool ->
                    def  dc = grailsApplication.getDomainClass( 'grus.tools.'+tool+'.'+tool )
                    
                    def toolObject = dc.clazz.newInstance(toolName : tool,phase :phase.id)
                    //save the created tool
                    toolObject.save(flush : true, failOnError : true)
                    //def item = [toolObject.id.toString() : tool]
                    
                    tools.put(toolObject.id.toString(),tool)
                }
                phase.tools=tools
                tools.each{k,v -> 
                    if(phase.currentTool == null){
                    phase.currentTool = UUID.fromString(k)
                        
                    }
                    
                }
                phase.save(flush:true)
                phaseNumber++
                itemsPhases.put(phaseNumber.toString(),phase.id.toString())
                

            }
            process.phases= itemsPhases
            if(itemsPhases['1']){
                process.currentPhase = UUID.fromString(itemsPhases['1'])
            }
            process.save(flush:true)
            

    		def meeting = new Meeting(topic : params.topic,description:params.description,startDate:params.startDate,endDate:params.endDate,typeOfMeeting:params.typeOfMeeting,facilitator:facilitator.id,process:process.id)
    		
           
            if(params.typeOfMeeting == "private"){
                meeting.participants = params.participants
                meeting.save(flush:true)
                facilitator.appendToMeetingsFacilitated(meeting.id.toString())
                facilitator.save(flush:true)
               for(userId in meeting.participants){
                    User.findById(userId).appendToMeetingsParticipatedIn(meeting.id.toString()).save(flush:true)
                } 
            }
            else{
                meeting.save(flush:true)
                facilitator.appendToMeetingsFacilitated(meeting.id.toString())
                facilitator.save(flush:true)
            }
            
            flash.messageTitle ="Meeting created with success"
            flash.message = 'Your meeting ('+meeting.topic+') is created ! '
            flash.messageType= "note-success"
            render(view: '/user/userNotification')
            return
               
    	}
    	else{
    		def processList = ProcessModel.findAll()
	    	def facilitators = User.findAllByRole("facilitator")
	    	def users = User.findAll()
			
	    	[processList:processList,facilitators:facilitators,users:users]
    	}
    	
    }
    def listAll(){
        def meetings = Meeting.findAll()

        def pictures = [:]
        def logins = [:]
        for(meeting in meetings){
            def facilitator = User.findById(meeting.facilitator)
            pictures[meeting.id]= facilitator.picture
            logins[meeting.id] =facilitator.login
        }

        render(view: '/meeting/listAll',model:[meetings:meetings,pictures:pictures,logins:logins])
        
    }
    def publicMeetings(){
        def meetings = Meeting.findAllByTypeOfMeeting('public')

        def pictures = [:]
        def logins = [:]
        for(meeting in meetings){
            def facilitator = User.findById(meeting.facilitator)
            pictures[meeting.id]= facilitator.picture
            logins[meeting.id] =facilitator.login
        }

        render(view: '/meeting/listAll',model:[meetings:meetings,pictures:pictures,logins:logins])
        
    }
    def myMeetings(){
        def meetingsIds = User.findByLogin(session.user.login).meetingsParticipatedIn
        def meetings = null
        if(meetingsIds != null){
            meetings = Meeting.findAllByIdInList(meetingsIds)
        }
        
            def pictures = [:]
            def logins = [:]
            for(meeting in meetings){
                def facilitator = User.findById(meeting.facilitator)
                pictures[meeting.id]= facilitator.picture
                logins[meeting.id] =facilitator.login
            }
            render(view: '/meeting/listAll',model:[meetings:meetings,pictures:pictures,logins:logins])
            
        
    }
    def facilitatorOf(){

        if(session.user.role =="facilitator"){
            def meetingsIds = User.findByLogin(session.user.login).meetingsFacilitated
            def meetings = null
            if(meetingsIds != null){
                meetings = Meeting.findAllByIdInList(meetingsIds)
            }
            
            def pictures = [:]
            def logins = [:]
            for(meeting in meetings){
                def facilitator = User.findById(meeting.facilitator)
                pictures[meeting.id]= facilitator.picture
                logins[meeting.id] =facilitator.login
            }
            render(view: '/meeting/listAll',model:[meetings:meetings,pictures:pictures,logins:logins])

            
        }
        else{
            flash.messageTitle ="Someting is wrong !!!"
            flash.message = 'You can not access to this page, you must be a facilitator '
            flash.messageType= "note-success"
            render(view: '/user/userNotification')
        }
        
            
        
    }
    def show(){
        def meeting = Meeting.findById(params.id)
        def facilitator = User.findById(meeting.facilitator)
        
        def nbOfMeetings = Meeting.countByFacilitator(facilitator.id)
        def participants =null
        if(meeting.participants){
            participants=User.findAllByIdInList(meeting.participants)
        }
        def process = Process.findById(meeting.process)
        def modelProcess = ProcessModel.findById(process.modelProcess)
        def phases= Phase.findAllByProcess(process.id)
        [meeting:meeting,facilitator:facilitator,nbOfMeetings:nbOfMeetings,participants:participants,modelProcess:modelProcess,phases:phases,process:process]
    }
    
}
