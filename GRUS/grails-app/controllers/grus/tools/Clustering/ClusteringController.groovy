package grus.tools.Clustering
import grus.Tool


import grus.Meeting
import grus.tools.Data
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
					def data= Data.findAll()
					[listIdeas:data]
			//	}
				
	
		
		
		
				
				
				
				
	}
	
	
}
