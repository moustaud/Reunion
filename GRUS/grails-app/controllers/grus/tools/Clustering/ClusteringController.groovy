package grus.tools.Clustering
import grus.tools.Brainstorming.Brainstorming
import grus.tools.Brainstorming.Idea
import grus.Phase
import grus.Process
import grus.Meeting
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

class ClusteringController {

    def index() {

    	def cluster = Clustering.findById(params.id)
    	def brainstorm = Brainstorming.findById(cluster.previousToolUUID)
    	def ideas = Idea.findAllByIdInList(brainstorm.ideas)
    	def meeting = getMeeting(cluster)
    	def isFacilitator = false
    	if(meeting.facilitator == session.user.id){
    		isFacilitator = true
    	}
    	
    	[cluster:cluster,brainstorm:brainstorm,ideas:ideas,isFacilitator:isFacilitator]
     }
     static def getMeeting(cluster){
     	def phase = Phase.findById(cluster.phase)
     	def process = Process.findById(phase.process)
     	def meeting = Meeting.findById(process.meeting)
     	return meeting
     }
    @MessageMapping("/addCluster")
    @SendTo("/topic/addCluster")
    protected String addCluster(String cluster) {

        
        def builder = new JsonBuilder()
        builder {
            message(cluster)
        }
        builder.toString()
        
    }
    @MessageMapping("/changeCluster")
    @SendTo("/topic/changeCluster")
    protected String changeCluster(String ideaCluster) {

        def ideaText = ideaCluster.substring(0, ideaCluster.indexOf('$'))
        def clusterText = ideaCluster.substring(ideaCluster.indexOf('$')+1)
        
        def builder = new JsonBuilder()
        builder {
            idea(ideaText)
            cluster(clusterText)
        }
        builder.toString()
        
    }
}
