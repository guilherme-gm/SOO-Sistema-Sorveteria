<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String bodyFile = "home.jsp";
	if (request.getAttribute("page") != null) {
		bodyFile = request.getAttribute("page").toString();
	}
	bodyFile = "pages/" + bodyFile;
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Pinguim Sorvetes</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="vendor/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="vendor/css/vendor.bundle.base.css">
<link rel="stylesheet" href="vendor/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="vendor/star-admin/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="images/favicon.png" />

<!-- Nosso CSS -->
<link rel="stylesheet" href="css/custom.css" />
</head>

<body>
	<div class="container-scroller">
		<!-- Barra superior -->
		<jsp:include page="header.jsp" />

		<!-- Corpo -->
		<div class="container-fluid page-body-wrapper">
			<!-- Barra lateral -->
			<jsp:include page="sidebar.jsp" />

			<!-- Região Central -->
			<div class="main-panel">
				<div class="content-wrapper">
					<jsp:include page="<%=bodyFile%>" flush="true" />
				</div>

				<!-- Rodapé -->
				<footer class="footer d-print-none">
					<jsp:include page="footer.jsp" />
				</footer>

			</div>

		</div>

	</div>

	<!-- JS -->
	<script src="vendor/js/vendor.bundle.base.js"></script>
	<script src="vendor/js/vendor.bundle.addons.js"></script>

	<script src="vendor/star-admin/js/off-canvas.js"></script>
	<script src="vendor/star-admin/js/misc.js"></script>

	<script src="vendor/star-admin/js/dashboard.js"></script>
	
	<script src="js/custom.js"></script>

</body>

</html>