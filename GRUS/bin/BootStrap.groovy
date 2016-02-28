import grus.User
import grus.Company
import grus.ProcessModel
import grus.PhaseModel
import grus.Phase
import grus.ToolModel
import grus.Meeting
import grus.tools.Data
import grus.tools.Brainstorming.Brainstorming
import grus.tools.Clustering.Clustering
import grus.tools.Voting.Voting
import grus.Tool

class BootStrap {

	def init = { servletContext ->
		//farhane test
	def facilitator1 = new User(firstName:"Abderrahime",lastName:"FARHANE",email:"farhane.abderrahime@gmail.com",login:"happy1991",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"facilitator",gender:"M",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def facilitator2=new User(firstName:"Evangeline",lastName:"Hammett",email:"omar.rachid@gmail.com",login:"omar2005",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"facilitator",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def user00 = new User(firstName:"Rachid",lastName:"FARHANE",email:"farhane.rachid@gmail.com",login:"rachid1991",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	
	def user01 =new User(firstName:"Cheryl",lastName:"Todd",email:"vitae.diam.Proin@loremtristique.co.uk",login:"rachid1992",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def user02 =new User(firstName:"Hunter",lastName:"Zelda",email:"eros@fermentumrisusat.com",login:"rachid1993",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def user03 =new User(firstName:"Giselle",lastName:"Wade",email:"eu@sollicitudin.edu",login:"rachid1994",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def user04 =new User(firstName:"Holly",lastName:"Aiko",email:"Aenean.euismod.mauris@blanditmattis.org",login:"rachid1995",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def user05 =new User(firstName:"Mannix",lastName:"Lara",email:"neque@non.com",login:"rachid1996",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	def user06 =new User(firstName:"Marshall",lastName:"Summer",email:"lacus.Aliquam.rutrum@molestie.ca",login:"rachid1997",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif").save(flash:true)
	
	def model01=new ProcessModel(processModelName : "Model 01 : phase01(brainStorm -> clusturing -> voting)").save(flash:true)
	def model02=new ProcessModel(processModelName : "Model 02 : brainStorm -> voting -> clusturing").save(flash:true)
	

	def phaseModel01 = new PhaseModel(modelPhaseName : "phase 01")
	def phaseModel02 = new PhaseModel(modelPhaseName : "phase 02")
	def itemsTools = [:]
	
	itemsTools.put("1","Brainstorming")
	itemsTools.put("2","Clustering")
	itemsTools.put("3","Voting")
	phaseModel01.toolsName= itemsTools
	phaseModel01.save(flush:true)
	itemsTools.put("1","Brainstorming")
	itemsTools.put("2","Voting")
	itemsTools.put("3","Clustering")
	phaseModel02.toolsName= itemsTools
	phaseModel02.save(flush:true)

	def itemsPhasesModel = [:]
	itemsPhasesModel.put("1",phaseModel01.id.toString())
	model01.phasesOfModel= itemsPhasesModel
	model01.save(flush:true)
	itemsPhasesModel.put("2",phaseModel02.id.toString())
	model02.phasesOfModel=itemsPhasesModel
	model02.save(flush:true)

	facilitator1.save(flush:true)
	facilitator2.save(flush:true)
	user01.save(flush:true)
	user02.save(flush:true)
	user03.save(flush:true)
	user04.save(flush:true)
	user05.save(flush:true)
	user06.save(flush:true)
	
	/*Tool modelProcess ModelPhase*/
	def tool01 =  new ToolModel(toolModelName:"Brainstorming",toolModelDescription:"a tool that's let you echange ideas",icon:"fa-users",label:"label-yellow")
	def tool02 =  new ToolModel(toolModelName:"Clustering",toolModelDescription:"make a cluster of group of ideas",icon:"fa-puzzle-piece",label:"label-blue")
	def tool03 =  new ToolModel(toolModelName:"Voting",toolModelDescription:"let you make a vote a bout a topic",icon:"fa-thumbs-o-up",label:"label-orange")
	tool01.save(flush:true)
	tool02.save(flush:true)
	tool03.save(flush:true)
	
	//moustapha test
	
	def newCompany= new Company(companyName :"capgemini",url: "www.capgemini.com", dataBaseLogin: "cap",dataBasePassword: "cap21", loginEq: "userName", passwordEq:"mdp")
	newCompany.save(flush: true,failOnError: true)
		

	
	}
	def destroy = {
	}
}