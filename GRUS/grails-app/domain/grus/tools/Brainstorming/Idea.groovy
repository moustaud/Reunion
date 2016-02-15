package grus.tools.Brainstorming
<<<<<<< HEAD
import grus.tools.Data
=======
>>>>>>> d68083f1845ae93840d117e5f299f71768fe9048

class Idea extends Data{
	
	
	String comment
	String author
	Date dateCreated

    static constraints = {
		comment blanck : false		
    }
}
