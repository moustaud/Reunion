package grus

class UserController {

    def index() {
	
	}

    def connect(){
        // this function it's for apply the view with de two forms :
        // one for login
        // and one for create new account

    }
    def logout(){
    	session.user = null;
    	redirect(controller: "page", action: "index")
	}
    def login(){

		if (params.login && params.password) {
				session.user == null;
				def user = User.findByLogin(params.login)
				if (user){
					def userSalt = user.salt
					def passHash = Password.getHashWithSalt(params.password, userSalt, "SHA-1")
					if( user.password == passHash) {
						def userInfoToSave = new User(firstName: user.firstName,lastName: user.lastName,login: user.login,role:user.role,picture:user.picture)
						session.user=userInfoToSave
						session.user.id=user.id
						redirect(controller: "user", action: "dashboard")					
					}
					else{
						redirect(controller: "user", action: "newAccountForm", params:[message:"Wrong password!", messageType:"alert-danger"])					
					}
				}
				else {
	                redirect(action:"loginForm", params:[message:"Error authentication, Failed to connect with these IDs!", messageType:"alert-warning"])
				}
		}
		else{
			redirect(action:"loginForm", params:[message:"could not find request params!", messageType:"alert-danger"])
		}
	
    }


    def newAccount(){
		if(params.login && params.email && params.password && params.firstName && params.lastName && params.passwordConfirmation){
			if(params.password == params.passwordConfirmation){
				try{
					def userSalt = Password.generateSalt()
					def passHash = Password.getHashWithSalt(params.password, userSalt, "SHA-1")
					User user = new User(firstName:params.firstName,lastName:params.lastName,login:params.login, email:params.email, password:passHash,role:"user",salt:userSalt,picture:"/users/default.gif")
					user.save(flush: true,failOnError: true)
					user = User.findByLogin(user.login)
					def userInfoToSave = new User(firstName: user.firstName,lastName: user.lastName,login: user.login,role:user.role)
					session.user=userInfoToSave
					redirect(action:"loginForm", params:[message:"Your new account has been created!", messageType:"alert-success"])
				}
				catch(e){
					redirect(action:"newAccountForm", params:[message:"Error, Failed to create new user account! "+e, messageType:"alert-warning"])
				}
			}
			else{
				redirect(action:"newAccountForm", params:[message:"Error, You must tape the same password! ", messageType:"alert-warning"])
			}
			
		}
		else{
			redirect(action:"newAccountForm", params:[message:"Error, Failed to create new user account! Please enter all fields", messageType:"alert-warning"])
		}
	}
		
    

    def loginForm(){
        render(view: "login",params:params)
    }
    def newAccountForm(){
        render(view: "newAccount",prams:params)
    }
    def dashboard(){
    
    }
    def profile(){
    	def user = User.findByLogin(session.user.login)
    	user.salt=null
    	[user:user]
    }
    def changeProfile(){
    	try{
    		def user = User.findByLogin(session.user.login)
	    	user.setFirstName(params.firstName)
	    	user.setLastName(params.lastName)
	    	user.setGender(params.gender)
	    	user.setCompany(params.company)
	    	user.setJob(params.job)
	    	
	    	user.save(failOnError: true,flush: true)
    		render(view: "profile",model:[user:user])
    	}
    	catch(e){
    		redirect(action:"changeProfileForm", params:[message:"Error, Failed to update new user account! "+e, messageType:"alert-warning"])
    	}
    }
    def chnageProfileForm(){
        render(view: "changeProfile",prams:params)
    }
    def uploadImage() {
	    def f = request.getFile('picture')
	    if (f.empty) {
	    	flash.messageTitle ="Error ! in uploading image"
	        flash.message = 'file cannot be empty'
	        flash.messageType= "note-danger"
	        render(view: 'userNotification')
	        return
	    }
	    def picture =grailsApplication.config.pathForGrailsApp+assetPath(src: "images/users/"+session.user.login+".jpg")
	    f.transferTo(new File(picture))
	    def user = User.findByLogin(session.user.login)
	    user.setPicture("users/"+user.login+".jpg")
	    user.save(failOnError: true,flush: true)
	    session.user.picture = "users/"+user.login+".jpg"
	    redirect(action:"profile", user:user)
	}
	static def userNotification(){
		
	}
	def isFacilitator(){
		if(session.user.role == "facilitator"){
			return true
		}
		else{
			return false
		}
	}
	def isAdmin(){
		if(session.user.role == "admin"){
			return true
		}
		else{
			return false
		}
	}
	
	
	
	
}
