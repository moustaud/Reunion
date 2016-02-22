import grus.User
import grus.ProcessModel
import grus.PhaseModel
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
		
		def model01=new ProcessModel(processModelName : "Model 01 : brainStorm -> clusturing -> voting").save(flash:true)
		def model02=new ProcessModel(processModelName : "Model 02 : brainStorm -> consensus -> voting").save(flash:true)
		def model03=new ProcessModel(processModelName : "Model 03 : brainStorm -> clusturing ").save(flash:true)
		def model04=new ProcessModel(processModelName : "Model 04 : brainStorm -> clusturing -> consensus -> voting").save(flash:true)
		def model05=new ProcessModel(processModelName : "Model 05 : brainStorm -> consensus -> brainStorm-> clusturing -> voting").save(flash:true)
		def meeting01=new Meeting(topic:"Meeting N° : 001",description:"private Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat iatur.",startDate: new Date(),endDate:new Date(),facilitator:facilitator1.id,typeOfMeeting:'private').save(flash:true)
		facilitator1.appendToMeetingsFacilitated(meeting01.id.toString())
		facilitator1.save(flush:true)
		def meeting02=new Meeting(topic:"Meeting N° : 002",description:"private Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",startDate: new Date(),endDate:new Date(),facilitator:facilitator1.id,typeOfMeeting:'private').save(flash:true)
		facilitator1.appendToMeetingsFacilitated(meeting02.id.toString())
		facilitator1.save(flush:true)
		def meeting03=new Meeting(topic:"Meeting N° : 003",description:"public Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",startDate: new Date(),endDate:new Date(),facilitator:facilitator1.id,typeOfMeeting:'public').save(flash:true)
		facilitator1.appendToMeetingsFacilitated(meeting03.id.toString())
		facilitator1.save(flush:true)
	
	
		def meeting04=new Meeting(topic:"Meeting N° : 004",description:"private not mine Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",startDate: new Date(),endDate:new Date(),facilitator:facilitator2.id,typeOfMeeting:'public').save(flash:true)
		facilitator2.appendToMeetingsFacilitated(meeting04.id.toString())
		facilitator2.save(flush:true)
		
	
	
		meeting01.appendToParticipants(user01.id.toString())
		user01.appendToMeetingsParticipatedIn(meeting01.id.toString())
	
		meeting01.appendToParticipants(user02.id.toString())
		user02.appendToMeetingsParticipatedIn(meeting01.id.toString())
	
		meeting01.appendToParticipants(user03.id.toString())
		user03.appendToMeetingsParticipatedIn(meeting01.id.toString())
	
		meeting02.appendToParticipants(user01.id.toString())
		user01.appendToMeetingsParticipatedIn(meeting02.id.toString())
	
		meeting02.appendToParticipants(user03.id.toString())
		user03.appendToMeetingsParticipatedIn(meeting02.id.toString())
	
		meeting02.appendToParticipants(user04.id.toString())
		user04.appendToMeetingsParticipatedIn(meeting02.id.toString())
	
		meeting02.appendToParticipants(user05.id.toString())
		user05.appendToMeetingsParticipatedIn(meeting02.id.toString())
	
		meeting02.appendToParticipants(user06.id.toString())
		user06.appendToMeetingsParticipatedIn(meeting02.id.toString())
	
		meeting04.appendToParticipants(facilitator1.id.toString())
		facilitator1.appendToMeetingsParticipatedIn(meeting04.id.toString())
	
		facilitator1.save(flush:true)
		facilitator2.save(flush:true)
		user01.save(flush:true)
		user02.save(flush:true)
		user03.save(flush:true)
		user04.save(flush:true)
		user05.save(flush:true)
		user06.save(flush:true)
		meeting01.save(flush:true)
		meeting02.save(flush:true)
		meeting03.save(flush:true)
		meeting04.save(flush:true)
		/*Tool modelProcess ModelPhase*/
    def tool01 =  new ToolModel(toolModelName:"Brainstorming",toolModelDescription:"a tool that's let you echange ideas",icon:"fa-users",label:"label-yellow")
    def tool02 =  new ToolModel(toolModelName:"Clustering",toolModelDescription:"make a cluster of group of ideas",icon:"fa-puzzle-piece",label:"label-blue")
    def tool03 =  new ToolModel(toolModelName:"Voting",toolModelDescription:"let you make a vote a bout a topic",icon:"fa-thumbs-o-up",label:"label-orange")
    tool01.save(flush:true)
    tool02.save(flush:true)
    tool03.save(flush:true)
	//moustapha test
	
	
		
	def brainstorming = new Brainstorming(toolName : "brainstorming 1", toolDescription:" premier meeting")
	brainstorming.save(flush: true, failOnError : true)
	
	def clustering = new Clustering(toolName : "clustering 1", toolDescription:" premier essai")
	clustering.save(flush: true, failOnError : true)
	
	def voting = new Voting(toolName : "voting 1", toolDescription:" premier essai")
	voting.save(flush: true, failOnError : true)
    }
    def destroy = {
    }
}

