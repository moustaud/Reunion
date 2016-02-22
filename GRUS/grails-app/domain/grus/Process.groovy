package grus

class Process {
	
	UUID modelProcess
	UUID currentPhase 
	Map<String,String> phases
	static constraints = {
		currentPhase nullable : true
		phases nullable : true
    }
}
