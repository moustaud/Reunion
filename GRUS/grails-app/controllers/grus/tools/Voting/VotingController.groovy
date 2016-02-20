package grus.tools.Voting
import grus.tools.Brainstorming.*
import grus.tools.Clustering.*
import grus.Tool
import grus.Meeting
import grus.tools.Data

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
				
				[listData:data]
			//	}
		
				
	}
}
