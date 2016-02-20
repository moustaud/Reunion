package grus.tools.brainstorming

import grus.tools.Brainstorming.Brainstorming
import grus.tools.Brainstorming.Idea
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder
import org.apache.commons.logging.LogFactory

class BrainstormingController {

    def index() { 

	}

	@MessageMapping("/brainstorm")
	@SendTo("/topic/brainstorm")
	protected String brainstorm(String chatMsg) 
	{	
			
		
		def idea = new Idea(data : chatMsg, author : "Moustapha", dateCreated : new Date().getTime()).save(flush : true)
		saveIdeas("brainstorming 1", idea)
		//saveIdeas(idea)
		def builder = new JsonBuilder()
		builder 
		{
			message(chatMsg)
			timestamp(new Date().getTime())
		}
		builder.toString()


		
	}
	
	
	static def saveIdeas(brainstormingName, idd) {
		def brainstorming = Brainstorming.findByToolName(brainstormingName)
		//def brainstorming = Brainstorming.findById(this.id)
	//	def idea = new Idea(comment : chatMsg, author : "Moustapha", dateCreated : new Date().getTime()).save(flush : true)
	//	println idd.id.toString()
		brainstorming.appendToIdeas(idd.id.toString())
		brainstorming.save(flush : true)		
	}
	
	
}