package grus.tools.Brainstorming
import grus.User

class Idea {
	
	int ideaId
	String comment
	static belongsTo = [author:User]
	

    static constraints = {
    }
}
