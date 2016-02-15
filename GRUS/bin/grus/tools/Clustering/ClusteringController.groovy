package grus.tools.Clustering
import grus.Tool
import grus.tools.Brainstorming.Idea

import grus.Meeting

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional


class ClusteringController {

    

    

	def start() {
				
				Meeting meeting = Meeting.get(params.id)
				def currentPhase= Phase.getById(meeting.process.currentPhaseId)
				def currentTool=Tool.getById(currentPhase.currentToolId)
				
				if(Tool.getById(currentTool.previousToolId)!=null){
					def previousTool=Tool.getById(currentTool.previousToolId)
					def data=previousTool.data.getAll()
					//def data= Data.findAll()
					[listIdeas:data]
				}
				
	
		
		
		
				
				
				
				
	}
	
	
}
