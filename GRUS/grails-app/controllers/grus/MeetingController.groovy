package grus

class MeetingController {
    
    def index() { }
    def add(){
    	if(request.method == 'POST'){
    	   
            def facilitator = User.findById(params.facilitator)
    		def meeting = new Meeting(topic : params.topic,description:params.description,startDate:params.startDate,endDate:params.endDate,typeOfMeeting:params.typeOfMeeting,facilitator:facilitator.id)
    		
           
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
    
}
