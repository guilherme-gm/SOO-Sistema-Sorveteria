<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String bodyFile = "home.jsp";
	if (request.getAttribute("page") != null) {
		bodyFile = request.getAttribute("page").toString();
	}
	bodyFile = "pages/" + bodyFile;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="vendor/bootstrap4.1.1/css/bootstrap.min.css">

<title>Hello, world!</title>
</head>
<body>
	<div class="container">
		<div id="wrap">
			<div id="main" class="container clear-top">
				<div class="row">
					<div class="col-sm-12">
						<jsp:include page="header.jsp" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<jsp:include page="menu.jsp" />
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<jsp:include page="<%=bodyFile%>" flush="true" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<footer class="footer"> <jsp:include page="footer.jsp" />
				</footer>
			</div>
		</div>

	</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script src="vendor/bootstrap4.1.1/js/bootstrap.min.js"></script>
</body>
</html>