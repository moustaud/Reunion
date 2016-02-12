package grus

class Tool {
	
	int toolId
	String topic
	String desciption
	
    static constraints = {
		topic unique : true
    }
}
