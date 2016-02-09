package grus

class UserController {

    def index() {}

    def connect(){
        // this function it's for apply the view with de two forms :
        // one for login
        // and one for create new account

    }
    def login(){
    }
    def newAccount(){}
    def loginForm(){
        render(view: "login",params:params)
    }
    def newAccountForm(){
        render(view: "newAccount",prams:params)
    }
}