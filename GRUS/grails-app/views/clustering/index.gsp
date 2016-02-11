<!DOCTYPE html>
<html lang="en">

<head>
	<script src='http://code.jquery.com/jquery-1.10.2.min.js' type="text/javascript"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Clustering Tool</title>



</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">

            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>Clustering</strong> Tool</h1>
                    <div class="description">

                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-5">

                    <div class="form-box">
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3>Please select a category for each idea, then press the button of validation</h3>
                            </div>
                            <div class="form-top-right">
                                <i class="fa fa-key"></i>
                            </div>
                        </div>
                        <div class="form-bottom">
                            <g:form name="clusteringForm" url="[controller:'clustering',action:'login']">
                                <div class="form-group">
                                    <label class="sr-only" for="login">Clusters</label>
                                    <input id="clusterInput" type="text" name="clusterName" value="" class="form-control" placeholder="Cluster Name">
                                    <button id="add" type="submit" class="btn btn-default btn-sm">Add Cluster</button>
                                    <div id="clusters"></div>
                                </div>
                                <g:actionSubmit name="add" class="btn sign" type="submit" value="Add Cluster" controller="user" action="login"/>
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


<script type="text/javascript">
	
    $('#add').click(function() {
        var essai=$("#clusterInput").val();
        $('#clusters').prepend("<span class='label label-success'>"+essai+"</span>"+"<br>");  
    });
      
</script>


</body>

</html>
