package tools
import gdss.User

class Clustering {
	
    String clusterName
    User clusterCreator
    static belongsTo = [clusterCreator: User]

    static constraints = {
    }
}



