package grus.tools.Voting

import grus.Tool

class Voting extends Tool{

	List<String> choices
    static constraints = {
    	choices nullable:true
    }
	
	
}
