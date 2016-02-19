package grus
import grus.tools.Data


class Tool {
		
//	UUID id
	String toolName
	String toolDescription
	//for decoration
	String icon = "fa-star"
	String label ="label-red"
	
//	UUID previousToolId
//	Data data	
	

   static constraints = {
		toolName nullable: false,blank:false, unique : true
    }
	
	
	static mapping = {
		toolName index: true
	}

}