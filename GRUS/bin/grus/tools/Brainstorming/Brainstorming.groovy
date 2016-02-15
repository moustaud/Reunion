package grus.tools.Brainstorming
import grus.Tool


class Brainstorming extends Tool {
		
	static hasMany = [ ideas : Idea]
    static constraints = {
    }
}
