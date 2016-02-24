import grusinscription.Employee
class BootStrap {

    def init = { servletContext ->
		
		def employee1 = new Employee(userName : "dgastli", mdp:" admin")
		employee1.save(flush: true, failOnError : true)
		def employee2 = new Employee(userName : "damel", mdp:" admin1")
		employee2.save(flush: true, failOnError : true)
		def employee3 = new Employee(userName : "dtaeib", mdp:" admin2")
		employee3.save(flush: true, failOnError : true)
		def employee4 = new Employee(userName : "dsadok", mdp:" admin3")
		employee4.save(flush: true, failOnError : true)
    }
    def destroy = {
    }
}
