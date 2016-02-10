package grus

class UserController {

    def index() {
	
}

    def connect(){
        // this function it's for apply the view with de two forms :
        // one for login
        // and one for create new account

    }
    def login(){

	if (params.login && params.password) {
			session.user == null;
			def user = User.findByLogin(params.login)
			if (user ){
				if( user.password == params.password) {
					session.user = user;
					redirect(controller: "user", action: "newAccountForm", params:[message:"Welcome ${user.login}, you are now connected!", messageType:"alert-success"])					
				}
			} else {
                redirect(action:"loginForm", params:[message:"Error authentication, Failed to connect with these IDs!", messageType:"alert-warning"])
			}
		} else {
			redirect(action:"loginForm", params:[message:"could not find request params!", messageType:"alert-danger"])
		}
	
    }


    def newAccount(){
		if(params.login && params.email && params.password && params.firstName && params.lastName && params.passwordConfirmation){
			if(params.password == params.passwordConfirmation){
				try{
					User u = new User(firstName:params.firstName,lastName:params.lastName,login:params.login, email:params.email, password:params.password,role:"user")
					u.save(flush: true,failOnError: true)
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
    

	
	
	
}
