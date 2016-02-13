package grus.tools.Clustering
import grus.Tool


import grus.User

class Clustering extends Tool{
	
    String clusterName
    User clusterCreator
    static belongsTo = [clusterCreator: User]

    static constraints = {
    }
}

