package grus.tools.Brainstorming
import java.util.Date;


import grus.Tool


class Brainstorming extends Tool {
		
	
	String comment
	String author
	Date dateCreated
	
    static constraints = {
		comment blanck : false
		
    }
}
