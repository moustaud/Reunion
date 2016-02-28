<!DOCTYPE html>

<html lang="en">

<head>
<script src='http://code.jquery.com/jquery-1.10.2.min.js'
	type="text/javascript"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Company Inscription</title>

<!-- CSS -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'stylesheets',file:'bootstrap.min.css')}" />
    <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'stylesheets',file:'font-awesome.min.css')}" />
    <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'stylesheets',file:'form-elements.css')}" />
    <link type="text/css" rel="stylesheet" href="${createLinkTo(dir:'stylesheets',file:'style.css')}" />
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/images/ico/easymeeting-ico.png">

</head>

<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">

				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>Company</strong> Inscription
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
							
								 <g:form name="loginForm" url="[controller:'user',action:'login']">

								<div class="form-group">
									<label class="sr-only" for="grusinscription">Company Name</label>
									<input id="CompanyName" type="text" name="CompanyName" value=""
										class="form-control" placeholder="Company Name" required="true"> <label
										class="sr-only" for="grusinscription">DataBase URL</label> <input
										id="DataBaseURL" type="text" name="DataBaseURL" value=""
										class="form-control" placeholder="DataBase URL" required="true"> <label
										class="sr-only" for="grusinscription">DataBase Login</label> <input
										id="DataBaseLogin" type="text" name="DataBaseLogin" value=""
										class="form-control" placeholder="DataBase Login" required="true">  <label
										class="sr-only" for="grusinscription">DataBase
										Password</label> <input id="DataBasePassword" type="text"
										name="DataBasePassword" value="" class="form-control"
										placeholder="DataBase Password" required="true"> 

									
									<label class="sr-only" for="grusinscription">Login</label> <input
										id="Login" type="text" name="Login" value=""
										class="form-control" placeholder="Login" required="true">  <label
										class="sr-only" for="grusinscription">Password</label> <input
										id="Password" type="text" name="Password" value=""
										class="form-control" placeholder="Password" required="true"> 
									
								</div>
								 <g:actionSubmit name="signin" class="btn sign" type="submit" value="Subscribe" controller="user" action="inscription"/>
                            </g:form>
							</div>

						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

	</div>




	




</body>

</html>
