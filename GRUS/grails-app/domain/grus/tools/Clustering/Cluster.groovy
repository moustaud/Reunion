package grus.tools.Clustering

import java.util.Date
import java.util.List;;

class Cluster {

	String data
	List<String> ideas
			  
	static constraints = {
	}
	
	static mapping = {
		
		data index: true
		}
}
