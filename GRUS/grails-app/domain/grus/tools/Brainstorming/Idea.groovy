package grus.tools.Brainstorming

class Idea {
		
	String comment
	String author
	Date dateCreated
	
//	static belongsTo = Brainstorming
		  
	static constraints = {
	}
	
	static mapping = {
		
		comment index: true
		}
}
