<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Star Admin Free Bootstrap Admin Dashboard Template</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="vendor/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="vendor/iconfonts/puse-icons-feather/feather.css">
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
		<div
			class="container-fluid page-body-wrapper full-page-wrapper auth-page">
			<div
				class="content-wrapper d-flex align-items-center auth auth-bg-1 theme-one">
				<div class="row w-100">
					<div class="col-lg-4 mx-auto">
						<div class="auto-form-wrapper">
							<form method="POST" action="DoLogin">
								<div class="form-group">
									<label class="label">Usuário</label>
									<div class="input-group">
										<input type="text" class="form-control" placeholder="Usuário"
											name="usuario">
										<div class="input-group-append">
											<span class="input-group-text"> <i
												class="mdi mdi-check-circle-outline"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="label">Senha</label>
									<div class="input-group">
										<input type="password" class="form-control"
											placeholder="*********" name="senha">
										<div class="input-group-append">
											<span class="input-group-text"> <i
												class="mdi mdi-check-circle-outline"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<button class="btn btn-primary submit-btn btn-block">Login</button>
								</div>
							</form>
						</div>
						<p class="footer-text text-center">copyright © 2018
							Bootstrapdash. All rights reserved.</p>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="vendor/js/vendor.bundle.base.js"></script>
	<script src="vendor/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="vendor/star-admin/js/off-canvas.js"></script>
	<script src="vendor/star-admin/js/misc.js"></script>
	<!-- endinject -->
</body>

</html>