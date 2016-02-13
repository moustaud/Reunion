package grus.tools.Clustering

import grus.Meeting

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional


class ClusteringController {

    

    def index(Integer max) {
        def selectedProcess = Meeting.executeQuery("select a from Process a " +
			"where a.visible = true or ? = 'admin' group by a.id,a.visible order by a.visible desc,a.title",
			[session.user?.role], params)
        respond selectedProcess

    }

	def start() {
		
				Meeting meeting = Meeting.get(params.id)
				//Brainstorming brainstorming = meeting.process.currentPhase.tools(toolId)				
				
				log.println("START CLUSTERING")
		
				redirect(action:"index", params:[id:params.id,listIdeas:listIdeas])
			}
	
}
