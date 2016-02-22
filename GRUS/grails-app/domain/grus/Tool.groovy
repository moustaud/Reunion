package grus

class Tool {
	String toolName
	String toolDescription
	UUID phase
		
    static constraints = {
		toolName nullable: false,blank:false
		toolDescription nullable:true
		phase nullable : true
    }
    static mapping = {
		toolName index: true
		phase index : true
	}
}
