package grus

class Meeting {
	
	int idMeeting
	Process process
	String topic 
	String description
	Date created
	Boolean typeOfMeeting
	static hasMany = [participants : User]
	static belongsTo = [ Facilitator : User ]
	
    static constraints = {
		topic unique : true
    }
}
