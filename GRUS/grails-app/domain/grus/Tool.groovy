package grus

class Tool implements Comparable{
	String toolName
	UUID phase
	Date created = new Date()	
    static constraints = {
		toolName nullable: false,blank:false
		
    }
    static mapping = {
		toolName index: true
		phase index : true
	}
	int compareTo(obj){
		created.compareTo(obj.created)
	}
}
