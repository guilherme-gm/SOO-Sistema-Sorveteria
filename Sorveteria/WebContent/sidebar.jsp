<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="usuario" scope="session"
	class="br.unesp.rc.pinguim.models.Funcionario" />
<nav class="sidebar sidebar-offcanvas d-print-none" id="sidebar">
	<ul class="nav">
		<li class="nav-item nav-profile">
			<div class="nav-link">
				<div class="user-wrapper">
					<div class="profile-image">
						<img src="images/logo.png" alt="logo" />
					</div>
				</div>
				<a class="btn btn-success btn-block" href="InserirVenda"> <i
					class="mdi mdi-currency-usd"></i> Registrar Venda
				</a>
			</div>
		</li>
		<li class="nav-item"><a class="nav-link" href="index.jsp"> <i
				class="menu-icon mdi mdi-home"></i> <span class="menu-title">Início</span>
		</a></li>
		<li class="nav-item"><a class="nav-link" data-toggle="collapse"
			href="#ui-produtos" aria-expanded="false" aria-controls="ui-produtos">
				<i class="menu-icon mdi mdi-content-copy"></i> <span
				class="menu-title">Produtos</span> <i class="menu-arrow"></i>
		</a>
			<div class="collapse" id="ui-produtos">
				<ul class="nav flex-column sub-menu">
					<c:if test="${ usuario.cargo eq 'GERENTE' }">
						<li class="nav-item"><a class="nav-link"
							href="InserirProduto">Inserir</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="ListarProdutos">Listar</a></li>
				</ul>
			</div></li>
		<c:if test="${ usuario.cargo eq 'GERENTE' }">
			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#ui-funcionario" aria-expanded="false"
				aria-controls="ui-funcionario"> <i
					class="menu-icon mdi mdi-account-card-details"></i> <span
					class="menu-title">Funcionários</span> <i class="menu-arrow"></i>
			</a>
				<div class="collapse" id="ui-funcionario">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="InserirFuncionario">Inserir</a></li>
						<li class="nav-item"><a class="nav-link"
							href="ListarFuncionarios">Listar</a></li>
					</ul>
				</div></li>
		</c:if>
		<li class="nav-item"><a class="nav-link" href="Sobre"> <i
				class="menu-icon mdi mdi-information-outline"></i> <span
				class="menu-title">Sobre</span>
		</a></li>
	</ul>
</nav>