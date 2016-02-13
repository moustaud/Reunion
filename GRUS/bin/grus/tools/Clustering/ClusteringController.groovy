package grus.tools.Clustering
import grus.Tool

import grus.Meeting

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional


class ClusteringController {

    

    def index(Integer max) {
       /* def selectedProcess = Meeting.executeQuery("select a from Process a " +
			"where a.visible = true or ? = 'admin' group by a.id,a.visible order by a.visible desc,a.title",
			[session.user?.role], params)
        respond selectedProcess*/

    }

	def start() {
		
				Meeting meeting = Meeting.get(params.id)
			    def phase= meeting.process.currentPhase  //je récupère la phase courrente
				for (tool in phase.tools) {   //je cherche le previousTool
					if (tool.toolId == previousToolId){
						Tool previousTool=tool
						def previousT = previousTool.findById(previousToolId)
						def listIdeas=user.ideas
						  //je cherche la bonne ligne dans le previous Tool
					}                                   
					
				}
				
				log.println("START CLUSTERING")
		
				redirect(action:"index", params:[id:params.id,listIdeas:listIdeas])
			}
	
}
