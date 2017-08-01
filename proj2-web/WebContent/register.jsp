<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>Bootstrap Login Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"  rel="stylesheet">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
       <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<style type="text/css">
.modal-footer {
       border-top: 0px;
}
</style>
</head>

<body>

       <!--login modal-->
       <div id="loginModal">
              <div class="modal-dialog">
                     <div class="modal-content">
                          
                           <!-- Header Section -->
                           <div class="modal-header">
                                  <h2>Welcome to CNN mynews</h2>
                                  <h3>Please sign in</h3>
                           </div>
                          
                           <!-- Body Section -->
                           <div class="modal-body">
                                  <form class="form col-md-12" action="RegisterServlet">

                                         <input type="text" name ="username" class="form-control input-lg" placeholder="Username" required autofocus />
                                         <input type="password" name="password" class="form-control input-lg" placeholder="Password" required />
                                         <input type="password" name="confirmPassword" class="form-control input-lg" placeholder="Confirm Password" required autofocus />
                                         <input type="text" name="email" class="form-control input-lg" placeholder="Email" required />
                                         <input type="text" name="name" class="form-control input-lg" placeholder="Name" required />
                                         <input type="text" name="phone" class="form-control input-lg" placeholder="Phone" required />
                                         
<!--                                          <label class="checkbox"> <input type="checkbox" -->
<!--                                                 value="remember-me" /> Remember me -->
<!--                                          </label> -->
                                        
                                         <button class="btn btn-primary btn-lg btn-block" type="submit" name="registerbutton" value="register">Register</button>
                                  </form>
                           </div>
                          
                           <!-- <!-- Footer Section -->
                        <!--    <div class="modal-footer">
                                  <div class="col-md-12">
                                         <span class="pull-left"><a href="#">Forgot Password?</a></span>
                                         <span><a href="register.jsp">Register</a></span>
                                  </div>
                           </div> -->
                     </div>
              </div>
       </div>

       
</body>
</html>
