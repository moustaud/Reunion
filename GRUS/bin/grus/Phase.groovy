package grus

class Phase {
	
	int phaseId
	String phaseDuration
	
	static hasMany = [ tools : Tool]
	static belongsTo =[ process : Process]
	

    static constraints = {
    }
}