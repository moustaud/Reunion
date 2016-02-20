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
							<strong>Voting</strong> Tool
						</h1>
						<div class="description"></div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-5">

						<div class="form-box">
							<div class="form-top">
								<div class="form-top-left">
									<h4>Please attribute a rank from 1 to 5 for each idea, then press the
										button of validation</h4>
								</div>
								<div class="form-top-right">
									<i class="fa fa-key"></i>
								</div>
							</div>
							<div class="form-bottom">

							
								<div class="form-group">
									<g:if test="${previousToul == 'Brainstorming'}">
									<table id="ideas">
										<tr>
											<td width=400><b>Idea</b></td>
											<td width=400><b>Author</b></td>
											<td width=33%><b>Ranking</b></td>
										</tr>
										</br>
										
										<g:each var="data" in="${listData}">

											<tr>
												<td width=400>
													${data.data}
												</td>
												<td width=400>
													${data.author}
												</td>
												
												<td width=width=33%><select id="${data.id}"><option>-Please vote-</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select></td>
												</br>
												</br>
											</tr>
										</g:each>
									</table>
									</g:if>
									<g:else>
     									<table id="ideas">
										<tr>
											<td width=400><b>Cluster</b></td>
											<td width=400><b>Ideas</b></td>
											<td width=33%><b>Ranking</b></td>
										</tr>
										</br>
										
										<g:each var="data" in="${listData}">

											<tr>
												<td width=400>
													${data.data}
												</td>
												<td width=400>
													<select id="${data.id}" style="width:120px">
														<g:each var="idea" in="${ideas[data.data]}">
															<option>${idea}</option>
														</g:each>
													</select>
												</td>
												
												<td width=width=33%><select id="${data.id}"><option>-Please vote-</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option></select></td>
												</br>
												</br>
											</tr>
										</g:each>
									</table>
									</g:else>

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

    
    
      
</script>



</body>

</html>
