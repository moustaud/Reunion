package grus.tools.Brainstorming
import grus.User

class Idea {
	
	UUID id
	String comment
	String author
	

    static constraints = {
		id generator : "uuid2"
		id index : true
		comment blanck : false		
    }
}
