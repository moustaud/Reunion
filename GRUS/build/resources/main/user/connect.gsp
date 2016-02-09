<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>GRUS Login &amp; Register Forms</title>

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
                    <h1><strong>GRUS</strong> Login &amp; Register Forms</h1>
                    <div class="description">

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Login to GRUS</h3>
                                <p>Enter username and password to log on:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <g:form name="loginForm" url="[controller:'user',action:'login']">
                                <div class="form-group">
                                    <label class="sr-only" for="login">Username</label>
                                    <g:textField id="login" name="login" class="form-control" placeholder="Username" required="true" />
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="password">Password</label>
                                    <g:passwordField id="password" name="password" class="form-control" placeholder="Password" required="true" />
                                </div>
                                <g:actionSubmit name="signin" class="btn sign" type="submit" value="Sign in" />
                            </g:form>
                        </div>
                    </div>

                    <div class="social-login">
                        <h3>...or login with:</h3>
                        <div class="social-login-buttons">
                            <a class="btn btn-link-1 btn-link-1-facebook" href="#">
                                <i class="fa fa-facebook"></i> Facebook
                            </a>
                            <a class="btn btn-link-1 btn-link-1-twitter" href="#">
                                <i class="fa fa-twitter"></i> Twitter
                            </a>
                            <a class="btn btn-link-1 btn-link-1-google-plus" href="#">
                                <i class="fa fa-google-plus"></i> Google Plus
                            </a>
                        </div>
                    </div>

                </div>

                <div class="col-sm-1 middle-border"></div>
                <div class="col-sm-1"></div>

                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Sign up now</h3>
                                <p>Fill in the form below to get instant access:</p>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-pencil"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <g:form name="newAccountForm" url="[controller:'user',action:'newAccount']">
                                <div class="form-group">
                                    <label class="sr-only" for="lastName">Last name</label>
                                    <g:textField id="lastName" name="lastName" class="form-control" placeholder="Last name" required="true" />
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="firstName">First name</label>
                                    <g:textField id="firstName" name="firstName" class="form-control" placeholder="First name" required="true" />
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="email">Email</label>
                                    <g:textField id="email" name="email" class="form-control" placeholder="Email" required="true" />
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="login">Username</label>
                                    <g:textField id="login" name="login" class="form-control" placeholder="Username" required="true" />
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="Password">Password</label>
                                    <g:passwordField id="Password" name="Password" class="form-control" type="password" placeholder="Password" required="true" />
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="PasswordConfirmation">Password</label>
                                    <g:passwordField id="PasswordConfirmation" name="PasswordConfirmation" type="password" class="form-control" placeholder="Password confirmation" required="true" />
                                </div>
                                <g:actionSubmit name="signup" class="btn sign" type="submit" value="Sign up" />
                            </g:form>
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

<!-- Javascript -->

<script type="text/javascript" src="${createLinkTo(dir:'javascripts',file:'jquery-2.2.0.min.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'javascripts',file:'bootstrap.js')}"></script>
<script type="text/javascript" src="${createLinkTo(dir:'javascripts',file:'newAccount.js')}"></script>



</body>

</html>
