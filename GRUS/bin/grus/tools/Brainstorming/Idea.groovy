package grus.tools.Brainstorming

class Idea {
		
	String data
	String author
	Date dateCreated
	
//	static belongsTo = Brainstorming
		  
	static constraints = {
	}
	
	static mapping = {
		
		data index: true
		}
}
