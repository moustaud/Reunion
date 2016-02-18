package grus

class ProcessModel {
	String name

    static constraints = {
    	name maxSize : 100, blank: false, nullable: false, unique : true
    }
    static mapping = {
		name index : true
		
	}
	
}
