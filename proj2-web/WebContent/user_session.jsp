<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if (session == null) {
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="assets/favicon.ico">

<title>User Session Bar</title>


<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link href="pretty/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="pretty/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet" type="text/css" />
<link href="pretty/seyma.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>

<!-- Bootstrap core CSS -->

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<!--  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script> -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</head>

<body>

	<div class="container">

		<!-- Static navbar -->
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">CNN MY NEWS</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<!-- <li class="active"><a href="/user_session.jsp">Home</a></li>
                           <li><a href="/newsAfrica.jsp">Africa</a></li>
						<li><a href="/newsAfrica.jsp">Africa</a></li>
						<li><a href="/newsUS.jsp">U.S</a></li>
						<li><a href="/newsEurope">Europe</a></li>
						<li><a href="/newsLatinAmerica.jsp">Latin America</a></li>
						<li><a href="/newsMiddleEast.jsp">Middle East</a></li>  -->
						<!-- US -->
						<!-- 				  <div class="seyma_searchs_div">-->
						<form action="UserSessionServlet">
							<input type="submit" class="btn btn-info" name="submitSearch"
								value="US"> <input type="submit" class="btn btn-info"
								name="submitSearch" value="Europe"> <input type="submit"
								class="btn btn-info" name="submitSearch" value="Africa">
							<input type="submit" class="btn btn-info" name="submitSearch"
								value="Asia"> <input type="submit" class="btn btn-info"
								name="submitSearch" value="Middle East"> <input
								type="submit" class="btn btn-info" name="submitSearch"
								value="Latin America">
						</form>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<!-- <li class="active"><a href="./">Default <span
								class="sr-only">(current)</span></a></li>
						<li><p> -->
						<form action="UserSessionServlet">
							<table>
								Date:
								<input name="date" type="text" id="datepicker">
								<input type="submit" value="datevalue" name="submitSearch" />
								</li> Hightlight:
								<input name="key" type="text">
								<input type="submit" value="keyvalue" name="submitSearch" />
								</li> Author:
								<input name="author" type="text">
								<input type="submit" value="authorvalue" name="submitSearch" />
								</li>
							
<%-- 								<% Object value = request.getAttribute("name"); %>
 --%>								<h1>Welcome <b><%=session.getAttribute("nome")%></b></h1> 

</body>

</table>
</form>
<!-- <li><a href="../navbar-fixed-top/">Fixed top</a></li>
 --></ul>

</div>
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	<ul class="nav navbar-nav navbar-right">

		<!-- ************************************************************************************************************** -->
		<!-- FORM TO LOGOUT -->
		<form action="LogoutServlet" method="get"
			class="navbar-form navbar-left" role="search">

			<!-- ************ -->
			<button type="submit" class="btn btn-danger" name="editprofileButton">Log
				out</button>
		</form>

	</ul>
</div>
<!-- /.navbar-collapse -->
<!--/.nav-collapse -->
</div>
<!--/.container-fluid -->



</nav>

<!-- Main component for a primary marketing message or call to action -->
<div class="jumbotron">
	<h1>CNN NEWS</h1>
	<p>

		<!-- VIDEO URL -->
		<a href="" target="_blank"><span
			class="glyphicon glyphicon-facetime-video"></span></a> <br />
		<!-- URL TO CNN -->
		<c:forEach items="${news}" var="n">

			<a href="" target="_blank"><c:out value="${n.getVideoUrl()}" /></a>




			<tr>
				<td><h2>
						<c:out value="${n.getTitle()}" />
					</h2></td>
			</tr>


			<!-- FOR EACH POINT OF THE ARTICLE'S HIGHLIGHTS -->
			<ul class="list-group" style="font-size: 10px;">
				<c:forEach items="${n.getHighlightList()}" var="h">
					<li class="list-group-item"
						style="background-color: transparent !important;">${h.getHighlight_title()}</li>
				</c:forEach>

			</ul>


			<p>


				<tr>
					<td><c:out value="${n.getText()}" /></td>
				</tr>


			</p>
			<div>
				<!-- DATE OF THE ARTCILE -->
				<span class="badge">${n.getDatetime()}</span>

				<!-- FOR EACH AUTHOR OF THE ARTICLE -->
				<c:forEach items="${n.getJournaList()}" var="a">
					<div class="pull-right">

						<span class="label label-success">"${a.getJournalistname()}"</span>

					</div>
				</c:forEach>
			</div>
			<br />
		</c:forEach>
	</p>
	<p>
<!-- 		<a class="btn btn-lg btn-primary" href="../../components/#navbar" -->
<!-- 			role="button">View navbar docs &raquo;</a> -->
	</p>
</div>

</div>
<!-- /container -->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!--  <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
