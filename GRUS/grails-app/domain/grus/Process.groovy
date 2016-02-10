package grus

class Process {
	
	int processId
	String processName
	String processDescription
	Phase currentPhase
	
	static hasMany = [phases : Phase]
	static belongTo  = [owner : User]
	

    static constraints = {
		processName (blank:false, unique:true)
    }
}
