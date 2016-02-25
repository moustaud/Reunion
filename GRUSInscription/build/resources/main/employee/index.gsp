<!DOCTYPE html>

<html lang="en">

<head>
<script src='http://code.jquery.com/jquery-1.10.2.min.js'
	type="text/javascript"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>GrusInscription</title>

<style type="text/css">
<!--
label {
	display: inline-block;
	width: 200px;
	text-align: left;
}

div#table {
	width: 225px;
	height: 300px;
	overflow: auto;
	position: relative;
}
​






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
							<strong>GRUS</strong> Inscription
						</h1>
						<div class="description"></div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h3>To register please complete this form</h3>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">


								<div class="form-group">
									<label class="sr-only" for="grusinscription">Firm Name</label>
									<input id="FirmName" type="text" name="FirmName" value=""
										class="form-control" placeholder="Firm Name"> </br> <label
										class="sr-only" for="grusinscription">DataBase URL</label> <input
										id="DataBaseURL" type="text" name="DataBaseURL" value=""
										class="form-control" placeholder="DataBase URL"> </br> <label
										class="sr-only" for="grusinscription">DataBase Login</label> <input
										id="DataBaseLogin" type="text" name="DataBaseLogin" value=""
										class="form-control" placeholder="DataBase Login"> </br> <label
										class="sr-only" for="grusinscription">DataBase
										Password</label> <input id="DataBasePassword" type="text"
										name="DataBasePassword" value="" class="form-control"
										placeholder="DataBase Password"> </br>

									<div>

										<p>
											<strong>Dictionnary of the firm DataBase</strong>
										</p>
										<p>Please enter the equivalent nomenclature of the
											following fields</p>
									</div>
									<label class="sr-only" for="grusinscription">Login</label> <input
										id="Login" type="text" name="Login" value=""
										class="form-control" placeholder="Login"> </br> <label
										class="sr-only" for="grusinscription">Password</label> <input
										id="Password" type="text" name="Password" value=""
										class="form-control" placeholder="Password"> </br>
									<button id="validate" type="button">Validate</button>
									</br> </br>
									<div class="panel-body" id="table">
										<table id="employees">
											<thead>
												<th id "employee>
												<td width=200><b><strong>Login</strong></b></td>


												</th>

											</thead>

											<tbody id="listOfEmployees">

												<g:each in="${employees}" var="employee">
													<tr id="${employee.id}">
														<td>
															${employee.userName}
														</td>
														<td><input type="checkbox" name="employees"
															value="${employee.id}"></td>



													</tr>
												</g:each>

											</tbody>

										</table>
									</div>
									<div class="col-md-2">
										<button id="addBtn" class="btn btn-primary" type="button"
											style="margin-bottom: 20px;">&nbsp;&nbsp;&nbsp;&nbsp;
											Add -->&nbsp;&nbsp;&nbsp;</button>
										<button id="removeBtn" class="btn btn-warning" type="button">
											&nbsp;&nbsp;<--Remove</button>
									</div>
									<div class="col-md-5">
										<div class="panel panel-yellow">
											<div class="panel-heading">Added Employees</div>
											<div class="panel-body">
												<table class="table table-hover">
													<thead>
														<tr>
															<th>#</th>
															<th>Username</th>
														</tr>
													</thead>
													<tbody id="added">



													</tbody>

												</table>
											</div>
										</div>
									</div>
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
			
			
			
			
			
    
$('#validate').click(function() {
   
   				
   				var firmName=$("#FirmName").val();
   				var dataBaseURL=$("#DataBaseURL").val();
   				var dataBaseLogin=$("#DataBaseLogin").val();
   				var dataBasePassword=$("#DataBasePassword").val();
   				var login=$("#Login").val();
   				var password=$("#Password").val();
   				
    	
        		alert(firmName+" "+dataBaseURL+" "+dataBaseLogin+" "+dataBasePassword+" "+login+" "+password);
        			
        			var form = {
    					"firmName": firmName,
    					"dataBaseURL": dataBaseURL,
    					"dataBaseLogin":dataBaseLogin,
    					"dataBasePassword":dataBasePassword,
    					"login":login,
    					"password":password
					}
        			
        			
        			
        	
       			
        		$.ajax({
            type: "POST",
            url: "/Employee/addEmployee",
            data: { form: JSON.stringify(form),},
            
        });
        
       /*  var employees="${employees}";
			alert(typeof employees);
			alert(employees.length);
			for (var employee=0;employee<employees.length;employee++ ) {
					alert("cc");
  					$( "added" ).prepend( "<tr width=400>Login</tr>" );
			}*/
    	
    });  
    
     $('#addBtn').click(function(){
            $('#listOfEmployees > tr').each(function() {
                var checkbox = $(this).find('td input').is(':checked');
                if(checkbox){
                alert("cc");
                    var idEmployee= $(this).attr('id');
                    var login =$(this).find('td').eq(1);
                  alert(login.html());
                    var userHtml ="<tr id='"+idEmployee+"'><td><input value='"+idEmployee+"' name='participants' type='checkbox' checked = 'true'/></td><td>"+login+"</td></tr>";
                    $('#added').append(userHtml);
                    $(this).remove();
                }
            });
        });
    
   
      
</script>



</body>

</html>
