package grus.tools.Voting

import java.util.List;
import java.util.UUID;

class Choice {
	
	
	String rank
	String data
	List<String> ideas
	UUID idPreviousTool
    static constraints = {
    }
	static mapping = {
		
		data index: true
		}
}
