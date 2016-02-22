package grus
import grails.converters.JSON
import grails.web.JSONBuilder
import groovy.json.JsonSlurper
class ProcessModelController {

    def index() { }
    def createProcessModel(){

    	if(request.method == 'POST'){
            //def modelName = params.modelName
            //def modelDescription = params.modelDescription
            
            def processModel = new ProcessModel(processModelName : params.modelName, processModelDescription: params.modelDescription)
    		processModel.save(flush:true)
            def converter = params as JSON
            def inputJSON = new JsonSlurper().parseText(converter.toString())
            
            def phases =new JsonSlurper().parseText(inputJSON.phases)
            def phaseNumber = 0
            def itemsPhases  = [:]
            phases.each{
                def phase = new PhaseModel(modelPhaseName : it.phaseName)
                def itemsTools = [:]
                def toolNumber = 0
                it.tools.each{
                    toolNumber++
                    itemsTools.put(toolNumber.toString(),it)
                }
                phase.toolsName= itemsTools
                phase.save(flush:true)
                phaseNumber++
                itemsPhases.put(phaseNumber.toString(),phase.id.toString())
                
            }
            processModel.phasesOfModel = itemsPhases
            processModel.save(flush:true)
            
    		   		
    	}
    	def tools = ToolModel.findAll()

    	[tools:tools]
        
    }
    def saveSuccess(){
        flash.messageTitle ="Process Model created with success"
        flash.message = 'Your Process Model  is created ! '
        flash.messageType= "note-success"
        render(view: '/user/userNotification')
    }
    
    
}
