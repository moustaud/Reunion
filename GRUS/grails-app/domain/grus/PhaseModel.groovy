package grus

class PhaseModel {
	String modelPhaseName
	Map<String,String> toolsName
    static constraints = {
    	toolsName nullable:true
    }
}
