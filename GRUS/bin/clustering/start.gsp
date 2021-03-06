<!DOCTYPE html>

<html lang="en">

<head>
<script src='http://code.jquery.com/jquery-1.10.2.min.js'
	type="text/javascript"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<asset:javascript src="websockets/application.js" />
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
							

									<div class="form-group">
										<label class="sr-only" for="login">Clusters</label> <input
											id="clusterInput" type="text" name="clusterName" value=""
											class="form-control" placeholder="Cluster Name">
										<button id="add" type="button" class="btn btn-default btn-sm">Add
											Cluster</button>
											</br>
										<div id="error"></div>
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
														${idea.data}
													</td>
													<td width=width=33%>
														${idea.author}
													</td>
													<td width=width=33%><select name="${idea.id}"
														id="${idea.id}" ></select></td>
													</br>
													</br>
												</tr>
											</g:each>
										</table>
										<button id="validate" type="button"
										class="btn btn-default btn-sm">Validate Clustering</button>

									</div>
									
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

	// il reste le test si c'est le facilitateur ou pas
	
    
    
    $(function() {
               
                var socket = new SockJS("${createLink(uri: '/stomp')}");
                var client = Stomp.over(socket);

                client.connect({}, function() {
                    
                    client.subscribe("/topic/createCluster", function(message) {
                        var chatMsg = JSON.parse(JSON.parse(message.body))
                                         
	


                    });
                });
                
                

        $('#add').click(function() {
    	
        var essai=$("#clusterInput").val();
        var bool=true;
        console.log(bool);
        
       
    		$("span").each(function(){
        		console.log("span");
        		console.log($(this).text());
        		console.log(essai);
        		if($(this).text()==essai){
        			bool=false;
        			$('#clusterInput').val("Please enter a different cluster");
        		
        		}
    		});
		 
       	
       	if(bool==true){
        	$('#clusters').prepend("<span class='label label-success'>"+essai+"</span>"+"<br>"); 
        	$.each($("select"), function() { $(this).prepend("<option >"+essai+"</option>"); });
    		client.send("/app/createCluster", {}, JSON.stringify($("#clusterInput").val()));
      	}
    	
    	$("#clusterInput").val("");
    	
    });
          
                
    
            });
     
  
   
   
   
   $('#validate').click(function() {
   
   				
   				var clusters = [];
   				
   				
    	
        		$.each($("select"), function() { 
        			var ideaId=($(this).attr('id'));
        			var clusterData =$(this).val();
        			
        			var cluster = {
    					"ideaId": ideaId,
    					"clusterData": clusterData
					}
        			
        			clusters.push(cluster);
        			
        		});
       			
        		$.ajax({
            type: "POST",
            url: "/Clustering/selectCluster",
            data: { clusters: JSON.stringify(clusters),},
            
        });
    	
    });  
    
    
    
    
    
      
</script>



</body>

</html>
