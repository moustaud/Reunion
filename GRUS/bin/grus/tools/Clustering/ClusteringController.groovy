package grus.tools.Clustering
import grus.Tool
import grus.tools.Brainstorming.*

import grus.Meeting
import grus.tools.Data

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder
import org.apache.commons.logging.LogFactory
import groovy.json.JsonSlurper 
//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional


class ClusteringController {

    

    

	def start() {
				/*
				Meeting meeting = Meeting.get(params.id)
				def currentPhase= Phase.getById(meeting.process.currentPhaseId)
				def currentTool=Tool.getById(currentPhase.currentToolId)
				
				if(Tool.getById(currentTool.previousToolId)!=null){
					def previousTool=Tool.getById(currentTool.previousToolId)
					def data=previousTool.getByTopic(previousTool.topic)			*/		
			//		def data= Data.findAll()
			//		[listIdeas:data]
			
				def previousTool=Brainstorming.findByToolName("brainstorming 1")
				
				def data = Idea.findAllByIdInList(previousTool.ideas)
				
		//		println data.length()
				[listIdeas:data]
			//	}
		
				
	}
	
	
	
	@MessageMapping("/createCluster")
	@SendTo("/topic/createCluster")
	
	protected String createCluster(String clusterName){
	
		def cluster= new Cluster(data :clusterName).save(flush : true)		

		saveClusters("clustering 1", cluster)
		def builder = new JsonBuilder()
		builder 
		{
			message(clusterName)
			
		}
		builder.toString()
	}
	
	
	
	
	def selectCluster(){
		def clustering = Clustering.findByToolName("clustering 1")
		def clusteringOutput = request.getParameter("clusters")
		def jsonObj = new JsonSlurper().parseText(clusteringOutput)
		jsonObj.each{
			def cluster=Cluster.findByData(it."clusterData")
			cluster.appendToIdeas(it."ideaId")
			cluster.save(flush : true)
			
		}

	}
	
	
	static def saveClusters(clusteringName, clusterid) {
		def clustering = Clustering.findByToolName(clusteringName)
		clustering.appendToClusters(clusterid.id.toString())
		clustering.save(flush : true)
	}
	
}
