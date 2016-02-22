package grus

class ProcessModel {
	String processModelName
	String processModelDescription
	Map<String,String> phasesOfModel
    static constraints = {
    	processModelName maxSize : 100, blank: false, nullable: false, unique : true
    	processModelDescription nullable: true
    	phasesOfModel nullable: true

    }
    static mapping = {
		processModelName index : true
		
	}
	
}
