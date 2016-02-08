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
    String address
    Date birthDay
    Date created = new Date()
    String role
    static constraints = {
        firstName maxSize : 30, blank: true, nullable: true
        lastName maxSize : 30, blank: true, nullable: true
        email email: true, blank: false, unique: true
        login size: 1..50, blank: false, unique: true
        password blank: false, nullable:false
        picture blank: true, nullable: true
        company maxSize : 100, blank: true, nullable: true
        gender inList : ["M", "F"], nullable:true
        job maxSize: 50, blank: true, nullable: true
        address maxSize: 255, blank: true, nullable: true
        birthDay nullable: true
        role inList : ["admin","facilitator","user"], nullable: false
    }
}
