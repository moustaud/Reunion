package grus

class Phase {

	String phaseName
	UUID process
    UUID currentTool
	Map<String,String> tools
	

    static constraints = {
    	tools nullable: true
        currentTool nullable:true
        process nullable:true
        

    }
    static mapping = {
    	phaseName index : true
    	process index : true
    }
}