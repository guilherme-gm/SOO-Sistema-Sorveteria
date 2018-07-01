<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="usuario" scope="session"
	class="br.unesp.rc.pinguim.models.Funcionario" />

<nav
	class="navbar default-layout col-lg-12 col-12 p-0 d-flex flex-row d-print-none">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
		<!-- Left navbar -->
	</div>
	<div class="navbar-menu-wrapper d-flex align-items-center">
		<ul class="navbar-nav navbar-nav-right">
			<c:if test="${ usuario.cargo eq 'GERENTE' }">

				<li class="nav-item dropdown"><a
					class="nav-link count-indicator dropdown-toggle"
					id="notificationDropdown" href="#" data-toggle="dropdown"> <i
						class="mdi mdi-bell"></i> <span class="count d-none"
						id="notif-count">0</span>
				</a>
					<div
						class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
						aria-labelledby="notificationDropdown">
						<a class="dropdown-item">
							<p class="mb-0 font-weight-normal float-left">
								Você tem <span id="notif-msg-count">0</span> novas notificações.
							</p> <!-- 						<span class="badge badge-pill badge-warning float-right">Ver -->
							<!-- 							Todas</span> -->
						</a>
						<div class="dropdown-divider"></div>
						<div id="notificacoes"></div>

					</div></li>
			</c:if>
			<li class="nav-item dropdown d-none d-xl-inline-block"><a
				class="nav-link dropdown-toggle" id="UserDropdown" href="#"
				data-toggle="dropdown" aria-expanded="false"> <span
					class="profile-text">Olá, <%=usuario.getNome()%></span> <img
					class="img-xs rounded-circle" src="images/faces/face1.jpg"
					alt="Profile image">
			</a>
				<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
					aria-labelledby="UserDropdown">
					<a class="dropdown-item mt-2" href="DoLogout"> Logout </a>
				</div></li>
		</ul>
		<button
			class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
			type="button" data-toggle="offcanvas">
			<span class="icon-menu"></span>
		</button>
	</div>
</nav>

<c:if test="${ usuario.cargo eq 'GERENTE' }">
	<script type="text/javascript" src="js/notificacao.js"></script>
</c:if>