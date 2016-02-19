package grus

class ProcessModelController {

	def index() { }
	def createProcessModel(){

		if(request.method == 'POST'){
			
			def index=0
			//def processModel = new ProcessModel(processModelName: params.processModelName,processModelDescription:params.processModelDescription)
			  println params.processModelDescription
		   // params.each{k,v ->
			//    println "${k} -- > ${v}"
			//}
					   
		}
		def tools = Tool.findAll()

		[tools:tools]
	}
}
