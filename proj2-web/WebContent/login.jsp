<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>CNN My News Login</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<style type="text/css">
.modal-footer {
	border-top: 0px;
}
</style>
</head>

<body>

	<div>

		<!-- Header Section -->
		<div class="modal-header">
			<h2>Welcome to CNN mynews</h2>
			
		</div>

		<img src="cnn.jpg" class="img-responsive img-rounded">
		
	</div>
	<!--login modal-->
	<div id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">

  <h3>Please sign in</h3>
				<!-- Body Section -->
				<div class="modal-body">
					<form class="form col-md-12" action="LoginServlet">

						<input type="text" name="username" class="form-control input-lg" placeholder="Username" required autofocus /> 
						<input type="password" name="password" class="form-control input-lg" placeholder="Password" required /> <label class="checkbox">
						<!-- <input type="checkbox"  value="remember-me" /> Remember me -->
						</label>

						<button class="btn btn-primary btn-lg btn-block" type ="submit" name="loginbutton" value="login">Login</button>
					</form>
				</div>

				<!-- Footer Section -->
				<div class="modal-footer">
					<div class="col-md-12">
						<!-- <!-- <span class="pull-left"><a href ="#">Forgot Password?</a></span>  -->
						<span><a href="register.jsp">Register</a></span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
		</form>
</body>
</html>
