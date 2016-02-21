package grus.tools.brainstorming

import grus.tools.Brainstorming.Brainstorming
import grus.tools.Brainstorming.Idea
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import org.apache.commons.logging.LogFactory
import grails.converters.*

class BrainstormingController {

    def index() 
	{ 
		
	}

	@MessageMapping("/brainstorm")
	@SendTo("/topic/brainstorm")
	protected String brainstorm(String chatMsg) 
	{
		def builder = new JsonBuilder()
		builder
		{
			message(chatMsg)
			timestamp(new Date().getTime())
		}
		builder.toString()
	}
	
	def saveIdeas()
	{
		def brainstormingOutput = request.getParameter("brains")		
		def jsonObj = new JsonSlurper().parseText(brainstormingOutput)
		def idea = new Idea(data : jsonObj.idee, author : "Moustapha", dateCreated : new Date().getTime()).save(flush : true)
		
		// put the idea in to the brainstorming
		def brainstorming = Brainstorming.findByToolName(jsonObj.idBrains)
		brainstorming.appendToIdeas(idea.id.toString())
		brainstorming.save(flush : true)
		render (view:'index') 

	}
	
	def migrateLastIdeas ()
	{
		UUID idPrevious = this.previousToolId
		while (idPrevious != null && Tool.findById(idPrevious).toolName != "BRAINSTORMING")
		{
			idPrevious = Tool.findById(idPrevious).previousToolId
		}
		if (idPrevious != null)
		{
			this.ideas = Tool.findById(idPrevious).ideas
			this.save(flush : true)
		//	render "migration ok !!!"
		}
		
	}
	
	
	
	
	
}
