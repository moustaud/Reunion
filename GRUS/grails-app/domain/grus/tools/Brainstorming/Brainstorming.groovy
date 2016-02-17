package grus.tools.Brainstorming

import grus.Tool


class Brainstorming extends Tool {
				
//	List ideas
	static hasMany = [ ideas : Idea]
	
    static constraints = {
			
    }
}