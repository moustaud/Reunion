package grus


class Tool {
	
	UUID id	
	String toolName
	String toolDesciption
	UUID previousToolId
	//UUID followingToolId
	String topic
	
	
    static constraints = {
		id generator : "uuid2"
		id index : true
		toolName (blank:false, unique:true)
		topic blank:false
    }
}
