package grus

class Tool {
	
	int toolId
	String topic
	String desciption
	int previousToolId
	int followingToolId
	
    static constraints = {
		topic unique : true
    }
}
