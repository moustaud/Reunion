package tools
import grus.Meeting

//import static org.springframework.http.HttpStatus.*
//import grails.transaction.Transactional


class ClusteringController {

    

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Clustering.list(params), model:[clusteringCount: Clustering.count()]
    }

	def start() {
		
				Meeting meeting = Meeting.get(params.id)
				Brainstorming brainStorming =  
				log.println("START CLUSTERING")
		
				redirect(action:"index", params:[id:params.id,listIdeas:listIdeas])
			}
	def lastIdeas() {
		Meeting meeting = Meeting.get(params.id)
			
		
		def jsona = JSON.parse(meeting.meetingData.json).get("ideaList").toString()
		render jsona
	}
}
