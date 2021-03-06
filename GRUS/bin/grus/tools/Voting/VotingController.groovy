package grus.tools.Voting
import grus.tools.Brainstorming.*
import grus.tools.Clustering.*
import grus.Tool
import grus.Meeting
import grus.tools.Data
import groovy.json.JsonSlurper

class VotingController {

    def index() {
				/*
				Meeting meeting = Meeting.get(params.id)
				def currentPhase= Phase.getById(meeting.process.currentPhaseId)
				def currentTool=Tool.getById(currentPhase.currentToolId)
				
				if(Tool.getById(currentTool.previousToolId)!=null){
					def previousTool=Tool.getById(currentTool.previousToolId)
					def data=previousTool.getByTopic(previousTool.topic)			*/		
			//		def data= Data.findAll()
			//		[listIdeas:data]
			
				//def previousTool = Brainstorming.findByToolName("brainstorming 1")
				def previousTool = Clustering.findByToolName("clustering 1")
				
				//def data = Idea.findAllByIdInList(previousTool.ideas)
				def data = Cluster.findAllByIdInList(previousTool.clusters)
				def previousToolType="Clustering"
				def ideas = [:]
				
				if(previousTool instanceof Clustering){
					println("clustering")
				}else if (previousTool instanceof Brainstorming){
					println("brainstorming")
				}
				
				
				data.each{ n->
					def listIdea=[]
					def ligne=n.ideas
					def clusterName=n.data
					ligne.each{s ->
						def idea = Idea.findById(s)
						listIdea.push(idea.data)
					}
					ideas.put(clusterName,listIdea)
					
					
				}
				
				
				/*
				if(previousToul instanceof Clustering){
					previousToolType="Clustering"
					def data = Cluster.findAllByIdInList(previousTool.clusters)
					data.each{ n->
					def listIdea=[]
					def ligne=n.ideas
					def clusterName=n.data
					ligne.each{s ->
						def idea = Idea.findById(s)
						listIdea.push(idea.data)
					}
					ideas.put(clusterName,listIdea)
					
				}
				
				}else if(previousToul instanceof Brainstorming){
					def data = Idea.findAllByIdInList(previousTool.ideas)
					previousToolType="Brainstorming"
				}*/
				
				[listData:data, previousToul:previousToolType, ideas:ideas]
			
		
				
	}
	
	
	def choice(){
	
		
	
		
		def voting = Voting.findByToolName("voting 1")
		def votingOutput = request.getParameter("choices")
		def jsonObj = new JsonSlurper().parseText(votingOutput)
		
		jsonObj.each{
			
			def choice= new Choice(data :it."data",author:it."author",rank:it."rank").save(flush : true)
			voting.appendToChoices(choice.id.toString())
			voting.save(flush : true)
			
		}
		

	}
}
