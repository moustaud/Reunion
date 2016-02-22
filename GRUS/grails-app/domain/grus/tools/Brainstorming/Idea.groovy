package grus.tools.Brainstorming

class Idea implements Comparable {
		
	String data
	String author
	Date dateCreated		  
	static constraints = {
	}
	
	static mapping = {
		
		data index: true
		}
	
	int compareTo(obj) {
		dateCreated.compareTo(obj.dateCreated)
	}
}
