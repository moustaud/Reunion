package grusinscription

class Employee {
	
	String userName
	String mdp
	
    static constraints = {
		
    }
	
	static mapping = {
		userName index : true
		mdp index : true
		
		
	}
}
