package grus

class User {
    String firstName
    String lastName
    String email
    String login
    String password
    String picture
    String gender
    String company
    String job
    String userAddress
    Date birthDay
    Date created = new Date()
    String salt = null
    String role
    List<String> meetingsFacilitated
    List<String> meetingsParticipatedIn    
    
    static constraints = {
        firstName maxSize : 30, blank: true, nullable: true
        lastName  maxSize : 30, blank: true, nullable: true
        email     email: true, blank: false, unique: true
        login     size:  5..50, blank: false, unique: true
        password  size:  5..50, blank: false, nullable:false
        picture   blank: true, nullable: true
        company   maxSize : 100, blank: true, nullable: true
        gender    inList : ["M", "F"], nullable:true
        job       maxSize: 50, blank: true, nullable: true
        userAddress maxSize: 255, blank: true, nullable: true
        birthDay nullable: true
        role inList : ["admin","facilitator","user"], nullable: false
    }
    static mapping = {
		login index : true
		email index : true
        role index :true
        
	}
}
