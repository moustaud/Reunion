package grus
import grus.tools.Data

class Tool {
	
	UUID id	
	String toolName
	String toolDesciption
	UUID previousToolId
	UUID followingToolId
	Data data
	
	
    static constraints = {
		id generator : "uuid2"
		id index : true
		toolName (blank:false, unique:true)
    }
}
