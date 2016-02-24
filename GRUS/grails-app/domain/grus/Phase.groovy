package grus

class Phase implements Comparable{

	String phaseName
	UUID process
    UUID currentTool
	Map<String,String> tools
	Date created = new Date()

    static constraints = {
    	tools nullable: true
        currentTool nullable:true
        process nullable:true
        

    }
    static mapping = {
    	phaseName index : true
    	process index : true
    }
    int compareTo(obj){
        created.compareTo(obj.created)
    }
}