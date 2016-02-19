package grus

class ProcessModel {
	String processModelName
	String processModelDescription
	Map<Integer,String> phasesOfModel
    static constraints = {
    	processModelName maxSize : 100, blank: false, nullable: false, unique : true
    }
    static mapping = {
		processModelName index : true
		
	}
	
}
