package grus.tools

import java.util.Date
import java.util.UUID;;

class Data {
	
	UUID id
	String comment
	String author
	Date dateCreated

    static constraints = {
		id generator : "uuid2"
		id index : true
    }
}
