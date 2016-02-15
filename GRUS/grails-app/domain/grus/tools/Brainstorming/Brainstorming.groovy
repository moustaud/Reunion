package grus.tools.Brainstorming
import java.util.Date;
import java.util.UUID;

import grus.Tool


class Brainstorming extends Tool {
		
	UUID id
	String comment
	String author
	String topic
	Date dateCreated
	
    static constraints = {
		id generator : "uuid2"
		id index : true
		comment blanck : false
		topic blank:false
    }
}
