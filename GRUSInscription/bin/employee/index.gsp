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
  width:200px;
  text-align: left;
}​
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
										<label class="sr-only" for="grusinscription">Firm Name</label> <input
											id="FirmName" type="text" name="FirmName" value=""
											class="form-control" placeholder="Firm Name">
										</br>
										<label class="sr-only" for="grusinscription">DataBase URL</label> <input
											id="DataBaseURL" type="text" name="DataBaseURL" value=""
											class="form-control" placeholder="DataBase URL">
										</br>
										<label class="sr-only" for="grusinscription">DataBase Login</label> <input
											id="DataBaseLogin" type="text" name="DataBaseLogin" value=""
											class="form-control" placeholder="DataBase Login">
										</br>
										<label class="sr-only" for="grusinscription">DataBase Password</label> <input
											id="DataBasePassword" type="text" name="DataBasePassword" value=""
											class="form-control" placeholder="DataBase Password">
										</br>
										
										<div>
  											
  											<p><strong>Dictionnary of the firm DataBase</strong></p>
  											<p>Please enter the equivalent nomenclature of the following fields</p>
										</div>
										<label class="sr-only" for="grusinscription">Login</label> <input
											id="Login" type="text" name="Login" value=""
											class="form-control" placeholder="Login">
										</br>
										<label class="sr-only" for="grusinscription">Password</label> <input
											id="Password" type="text" name="Password" value=""
											class="form-control" placeholder="Password">
										</br>
										<button id="validate" type="button" >Validate</button>
										</br>
										</br>
										<table id="employees">
											<tr id "employee>
												<td width=400><b><strong>Login</strong></b></td>
												<td width=33%><b><strong>Password</strong></b></td>
												<td width=33%><b><button id="addEmployee" type="button" >Add Empolyee</button></b></td>
												
												<i class='fa fa-ok'/>
											</tr>
											
											

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
			var employees="${employees}";
			alert(JSON.stringify("${employees}"));
			alert(employees.length);
			for (var employee=0;employee<employees.length;employee++ ) {
					alert("cc");
  					$( "employees" ).prepend( "<tr width=400>Login</tr>" );
			}
			
			
			
			
    
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
    	
    });  
    
    
    
      
</script>



</body>

</html>
