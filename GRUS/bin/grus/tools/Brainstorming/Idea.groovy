package grus.tools.Brainstorming
import grus.User

class Idea {
	
	String comment
	String author
	//static belongsTo = [author:User]
	
	

	

    static constraints = {
    }
	
	static mapping = {
		author index : true
		
	}
}
