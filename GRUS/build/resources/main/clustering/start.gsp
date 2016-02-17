<!DOCTYPE html>

<html lang="en">

<head>
<script src='http://code.jquery.com/jquery-1.10.2.min.js'
	type="text/javascript"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<asset:javascript src="websockets/application.js"/>
        <asset:javascript src="websocets/jquery" />
        <asset:javascript src="spring-websocket" />
<title>Clustering Tool</title>

<style type="text/css">
<!--
div#clusters {
	width: 225px;
	height: 150px;
	overflow: auto;
	position: relative;
	left: 73px;
}
-->
</style>

</head>

<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">

				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>Clustering</strong> Tool
						</h1>
						<div class="description"></div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>Please select a category for each idea, then press the
										button of validation</h3>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">
							<!--  	<g:form name="clusterForm"
									url="[controller:'clustering',action:'saveClusters']">-->

									<div class="form-group">
										<label class="sr-only" for="login">Clusters</label> <input
											id="clusterInput" type="text" name="clusterName" value=""
											class="form-control" placeholder="Cluster Name">
										<button id="add" type="button" class="btn btn-default btn-sm">Add
											Cluster</button>
										<div id="clusters"></div>
										<table id="ideas">
											<tr>
												<td width=400><b>Idea</b></td>
												<td width=33%><b>Author</b></td>
												<td width=33%><b>Cluster</b></td>
											</tr>
											</br>
											<g:each var="idea" in="${listIdeas}">

												<tr>
													<td width=400>
														${idea.comment}
													</td>
													<td width=width=33%>
														${idea.author}
													</td>
													<td width=width=33%><select name= "${idea.id}" id="${idea.id}"><option value="${cluster.data}">empty</option></select></td>
													</br>
													</br>
												</tr>
											</g:each>
										</table>

										
									</div>
								<!--     <g:actionSubmit type ="button" name="validateClustering" class="btn sign"  value="Validate Clustering" controller="clustering" action="saveClusters" />
                            </g:form>-->
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>




	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">

				<div class="col-sm-8 col-sm-offset-2">
					<div class="footer-border"></div>

				</div>

			</div>
		</div>
	</footer>

	<script type="text/javascript">


	
    $('#add').click(function() {
    	
        var essai=$("#clusterInput").val();
        
        //var balise;
        $('#clusters').prepend("<span class='label label-success'>"+essai+"</span>"+"<br>"); 
        client.send("/app/createCluster", {}, JSON.stringify($("#clusterInput").val()));
        /*
        
        for (var i=0; i< listideas.length; i++){
        	balise=$(document.getElementById(i));
    		balise.prepend("<option >"+essai+"</option>");
    	}*/
    	
    	$.each($("select"), function() { $(this).prepend("<option >"+essai+"</option>"); });
    });
    
    $(function() {
                //Create a new SockJS socket - this is what connects to the server
                //(preferably using WebSockets).
                var socket = new SockJS("${createLink(uri: '/stomp')}");
                //Build a Stomp client to send messages over the socket we built.
                var client = Stomp.over(socket);

                //Have SockJS connect to the server.
                client.connect({}, function() {
                    //Subscribe to the 'chat' topic and define a function that is executed
                    //anytime a message is published to that topic by the server or another client.
                    client.subscribe("/topic/createCluster", function(message) {
                      console.log(message)
                        var chatMsg = JSON.parse(JSON.parse(message.body))
                                                
			$("#clusters").append('<strong>Moustapha said : </strong> '+ chatMsg.message + "<br/>" "<br/>");


                    });
                });
                
                

               
    
    
    
    
    
      
</script>



</body>

</html>
