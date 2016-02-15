<!DOCTYPE html>

<html lang="en">

<head>
<script src='http://code.jquery.com/jquery-1.10.2.min.js'
	type="text/javascript"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
									<button id="add" type="submit" class="btn btn-default btn-sm">Add
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
												<td width=width=33%><select id="${idea.id}"><option>empty</option></select></td>
												</br>
												</br>
											</tr>
										</g:each>
									</table>


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


	
    $('#add').click(function() {
    	
        var essai=$("#clusterInput").val();
        //var balise;
        $('#clusters').prepend("<span class='label label-success'>"+essai+"</span>"+"<br>"); 
        /*
        
        for (var i=0; i< listideas.length; i++){
        	balise=$(document.getElementById(i));
    		balise.prepend("<option >"+essai+"</option>");
    	}*/
    	
    	$.each($("select"), function() { $(this).prepend("<option >"+essai+"</option>"); });
    });
    
    
    
    
    
      
</script>



</body>

</html>
