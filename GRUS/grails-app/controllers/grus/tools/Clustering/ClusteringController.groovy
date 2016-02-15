package grus.tools.Clustering
import grus.Tool
import grus.tools.Brainstorming.Idea

import grus.Meeting

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional


class ClusteringController {

    

    

	def start() {
				/*
				Meeting meeting = Meeting.get(params.id)
			    def phase= meeting.process.currentPhase  //je récupère la phase courrente
				for (tool in phase.tools) {   //je cherche le previousTool
					if (tool.toolId == previousToolId){
						Tool previousTool=tool
						def previousT = previousTool.findById(previousToolId)
						def listIdeas=previousT.ideas
						  //je cherche la bonne ligne dans le previous Tool
					}                                   
					
				}*/
		/*
		 def list =[];
		 def ligne = new Idea(1,"couleur bleue", "dorra");
		 def ligne=["couleur bleue", "dorra", "empty"];
		 list.add(ligne);
		 ligne=["couleur jaune", "sadok", "empty"];
		 ligne=new Idea(2,"couleur jaune", "sadok");
		 list.add(ligne);
		 ligne=["petite taille", "taeib", "empty"];
		 ligne= new Idea(3,"taille petite", "taeib");
		 list.add(ligne);
		 log.println(list)*/
		
		def idea= Idea.findAll()
		[listIdeas:idea]
				
				
				
				
	}
	
	
}
