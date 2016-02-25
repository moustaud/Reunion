package grus

class Process {
	
	UUID modelProcess
	UUID currentPhase
	UUID meeting
	Map<String,String> phases
	static constraints = {
		currentPhase nullable : true
		phases nullable : true
		meeting nullable:true
    }
}
