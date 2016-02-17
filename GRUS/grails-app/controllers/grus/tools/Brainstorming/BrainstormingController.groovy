package grus.tools.brainstorming


import grus.tools.Brainstorming.Brainstorming
import grus.tools.Brainstorming.Idea
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder
import org.apache.commons.logging.LogFactory

class BrainstormingController {

    def index() { }

	@MessageMapping("/brainstorm")
	@SendTo("/topic/brainstorm")
	protected String brainstorm(String chatMsg) 
	{	
		def brainstorming = Brainstorming.findByToolName("brainstorming 1")
		def idea = new Idea(comment : chatMsg, author : "Moustapha", dateCreated : new Date().getTime()).save(flush : true)
		brainstorming.addToIdeas(idea)
		brainstorming.save(flush : true)	
									
		def builder = new JsonBuilder()
		builder 
		{
			message(chatMsg)
			timestamp(new Date().getTime())
		}
		builder.toString()
		
	}
	
}