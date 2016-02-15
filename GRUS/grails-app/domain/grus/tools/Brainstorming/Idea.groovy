package grus.tools.Brainstorming

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
