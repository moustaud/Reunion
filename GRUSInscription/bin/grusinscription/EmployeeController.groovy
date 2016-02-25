package grusinscription
import groovy.json.JsonSlurper

class EmployeeController {

    def index() {
		
		def employees= Employee.findAll();
		println("ko")
		println (employees.size())
		println (employees)
		[employees: employees]
		
		
	}
	def addEmployee(){
		def form = request.getParameter("form")
		println(form)
		def jsonObj = new JsonSlurper().parseText(form)
		
		def firm= new Firm(firmName :jsonObj.firmName).save(flush : true)
		println("ok")
		
		
	}
}
