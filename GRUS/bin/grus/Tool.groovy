package grus
import grus.tools.Data


class Tool {
		
//	UUID id
	String toolName
	String toolDescription
//	UUID previousToolId
//	Data data	
	

    static constraints = {
	//	id generator : "uuid2"
	//	id index : true	
	//	toolName (blank:false, unique:true)
    }
	
	
	static mapping = {
	
	toolName index: true
	}

}