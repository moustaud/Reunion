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
	}
    def login(){

		if (params.login && params.password) {
				session.user == null;
				def user = User.findByLogin(params.login)
				if (user){
					def userSalt = user.salt
					def passHash = Password.getHashWithSalt(params.password, userSalt, "SHA-1")
					if( user.password == passHash) {
						def userInfoToSave = new User(firstName: user.firstName,lastName: user.lastName,login: user.login,role:user.role)
						session.user=userInfoToSave
						redirect(controller: "user", action: "newAccountForm", params:[message:"Welcome ${user.login}, you are now connected!", messageType:"alert-success"])					
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
					User user = new User(firstName:params.firstName,lastName:params.lastName,login:params.login, email:params.email, password:passHash,role:"user",salt:userSalt)
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
    

	
	
	
}
