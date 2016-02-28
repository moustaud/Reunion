package grus

class Tool implements Comparable{
	String toolName
	UUID phase
	Date created = new Date()
	String nextToolType
	UUID nextToolUUID	
	String previousToolType
	UUID previousToolUUID
    static constraints = {
		toolName nullable: false,blank:false
		nextToolUUID nullable:true
		nextToolType nullable:true
		previousToolUUID nullable:true
		previousToolType nullable:true
    }
    static mapping = {
		toolName index: true
		phase index : true
	}
	int compareTo(obj){
		created.compareTo(obj.created)
	}
}
