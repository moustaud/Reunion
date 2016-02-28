package grus

class Company {
	
	String companyName
	String url
	String dataBaseLogin
	String dataBasePassword
	String loginEq
	String passwordEq

    static constraints = {
		companyName maxSize : 50, blank: false, nullable: false
		url blank: false, nullable: false
		dataBaseLogin maxSize : 20, blank: false, nullable: false
		dataBasePassword maxSize : 20, blank: false, nullable: false
		loginEq maxSize : 20, blank: false, nullable: false
		passwordEq maxSize : 20, blank: false, nullable: false
    }
	
	static mapping = {
		companyName index : true
		
		
		
	}
}