package grus.tools.Brainstorming

class Idea {
	String data
	String author
	Date created = new Date()
	static constraints = {
		author nullable: true
	}
	static mapping = {
		data index : true
		author index : true
		
	}
}

