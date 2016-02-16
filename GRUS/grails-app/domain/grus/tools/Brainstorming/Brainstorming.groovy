package grus.tools.Brainstorming

import grus.Tool


class Brainstorming extends Tool {
		
	
	static hasMany = [ ideas : Idea]
/*	
	static mapping = {
		ideas column:'Idea.id',joinTable: false
	  }
*/	  
	
    static constraints = {
			
    }
}