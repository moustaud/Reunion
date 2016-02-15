package grus.tools.Clustering
import grus.Tool


import grus.User

class Clustering extends Tool{
	
	static hasMany = [ clusters : Cluster]

    static constraints = {
    }
}

