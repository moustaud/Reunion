package grus

class Meeting {
	// The id is generated by grails and stored to cassandra as a UUID type
	String topic 
	String description
	Date created = new Date()
	Date startDate
	Date endDate
	UUID process
	UUID facilitator
	List<String> participants
	//UUID createdBy
	String state = "coming"
	/* 
		can take two value : coming, open, closed, finished 
		by default the meeting is not begin yet so it's coming
		when the current date is between startDate and endDate the meeting is open
		if the facilitator stops the meeting the state take closed as value
		when the current date is higher than endDate end the facilitator don't have 
		closed the meeting the state take finished as value 
		if you chose start now from the view the startDate take the current date
	*/ 
	String typeOfMeeting = "private"// can take two of value : private or public
	

	
    static constraints = {
    	topic maxSize : 100, blank: false, nullable: false
		description blank: true, nullable: true
		startDate nullable:true
		endDate nullable:true
		typeOfMeeting inList : ["private","public"], nullable: false
		process nullable : true
    }
    static mapping = {
		typeOfMeeting index : true
		facilitator index : true
		participants indexColumn: [name: "the_participants", type: String]
		
        
	}
    
}
