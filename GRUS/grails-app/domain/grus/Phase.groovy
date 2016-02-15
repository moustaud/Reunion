package grus

class Phase {
	
	UUID id	
	String phaseName
	String phaseDuration
	UUID currentToolId
	
	static hasMany = [ tools : Tool]
	static belongsTo =[ process : Process]
	

    static constraints = {
		id generator : "uuid2"
		id index : true
		phaseName blank:false
    }
}