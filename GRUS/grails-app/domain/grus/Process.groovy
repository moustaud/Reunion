package grus

class Process {
	UUID id	
	String processName
	String processDescription
	UUID currentPhaseId
	
	static hasMany = [phases : Phase]
	static belongsTo  = [facilitator : User]
	static belongsTo = [ meeting : Meeting ]
	

    static constraints = {
		id generator : "uuid2"
		id index : true				
		processName (blank:false, unique:true)
    }
}
