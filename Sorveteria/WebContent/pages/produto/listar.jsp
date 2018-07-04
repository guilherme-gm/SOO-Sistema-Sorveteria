<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="usuario" scope="session"
	class="br.unesp.rc.pinguim.models.Funcionario" />
<h2>Produtos</h2>
<a href="#" class="print-btn"><i class="mdi mdi-printer"></i>
	Relatório</a>
<br />
<br />

<div class="card">
	<div class="card-body">
		<table class="table table-hover table-responsive">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Categoria</th>
					<th>Estoque Atual</th>
					<th>Estoque Mínimo</th>
					<th>Preço Venda</th>
					<th>Preço Compra</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td><c:out value="${ produto.codigo }" /></td>
						<td><c:out value="${ produto.nome }" /></td>
						<td><c:out value="${ produto.categoria }" /></td>
						<td><c:out value="${ produto.quantidadeEstoque }" /></td>
						<td><c:out value="${ produto.estoqueMinimo }" /></td>
						<td><c:out value="${ produto.precoVenda }" /></td>
						<td><c:out value="${ produto.precoCompra }" /></td>
						<td><c:if test="${ usuario.cargo eq 'GERENTE' }">
								<a href="AtualizarProduto?codigo=${ produto.codigo }"><i
									class="mdi mdi-pencil"></i></a>
							</c:if>&nbsp;</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
