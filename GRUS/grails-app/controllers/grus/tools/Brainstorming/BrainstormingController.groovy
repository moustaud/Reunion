package grus.tools.Brainstorming
import grus.tools.Brainstorming.Idea
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
class BrainstormingController {

    def index() { 
    	/*
			The Go! button in the show meeting view send the id of the tool (here the Brainstorming) 
			to Brainstorming controller so we can get the phase the process and the meeting ;)
    	*/
    	def brainstorm = Brainstorming.findById(params.id)
        def ideas = null 
        if(brainstorm.ideas){
         ideas = Idea.findAllByIdInList(brainstorm.ideas)
            
        }
    	[brainstorm:brainstorm,ideas:ideas]
 
    }
    
    @MessageMapping("/addIdea")
    @SendTo("/topic/addIdea")
    protected String addIdea(String ideaId) {

        def idea = Idea.findById(UUID.fromString(ideaId))
        def authorIdea = null
        
        
        def builder = new JsonBuilder()
        builder {
            message(idea.data)
            created(idea.created.format('dd/MM/yyyy HH:mm:ss'))
            author(idea.author)

        }
        builder.toString()
        
    }
    def saveIdea(){
        if(request.method == 'POST'){
                def ideaJson = new JsonSlurper().parseText(request.getParameter("idea"))
                def idea = null
                if(ideaJson.anonym == "true"){
                    idea = new Idea(data : ideaJson.ideaText).save(flush : true)
                }
                else{
                    idea = new Idea(data : ideaJson.ideaText,author : session.user.login).save(flush : true)
                }

              def brainstorm = Brainstorming.findById(ideaJson.brainstormingId)
              brainstorm.appendToIdeas(idea.id.toString()).save(flush:true)
              render idea.id
              
        }

            
        
    }
}
