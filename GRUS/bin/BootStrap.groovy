import grus.User
//import grus.tools.Brainstorming.Idea
class BootStrap {

    def init = { servletContext ->
    def user  = new User(firstName:"Abderrahime",lastName:"FARHANE",email:"farhane.abderrahime@gmail.com",login:"happy1991",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"M",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif")
    def user2 = new User(firstName:"Rachid",lastName:"FARHANE",email:"farhane.rachid@gmail.com",login:"rachid1991",password:"CF0B0868230AEA34163110449C192FEF4D815C24",salt:"C6F99C2E962736706C2C2DA16406E241E3364AE2",role:"user",gender:"F",userAddress:"Fes, Morocco",job:"Student",company:"ENSEEIHT",picture:"users/default.gif")
    user.save(flash:true)
    user2.save(flash:true)
	/*def idea1=new Idea(comment:"couleur rouge", author:"dorra")
	idea1.save()
	def idea2=new Idea(comment:"couleur jaune", author:"sadok")
	idea2.save()
	def idea3=new Idea(comment:"taille petite", author:"taeib")
	idea3.save()*/
    }
    def destroy = {
    }
}

