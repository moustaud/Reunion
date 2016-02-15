package grus.tools.Brainstorming
import grus.tools.Data

class Idea extends Data{
	
	
	String comment
	String author
	Date dateCreated

    static constraints = {
		comment blanck : false		
    }
}
