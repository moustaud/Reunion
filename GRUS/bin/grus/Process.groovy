package grus

class Process {
	UUID id	
	String processName
	String processDescription
	UUID currentPhaseId
	
	static hasMany = [phases : Phase]
<<<<<<< HEAD
	static belongsTo  = [facilitator : User, meeting : Meeting ]
=======
	static belongsTo  = [facilitator : User , meeting : Meeting]
>>>>>>> d68083f1845ae93840d117e5f299f71768fe9048
	

    static constraints = {
		id generator : "uuid2"
		id index : true				
		processName (blank:false, unique:true)
    }
}
