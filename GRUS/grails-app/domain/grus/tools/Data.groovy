package grus.tools

import java.util.UUID;

class Data {

	UUID id
	
    static constraints = {
		id generator : "uuid2"
		id index : true
    }
}
