<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Produto</h2>

<div class="card">
	<div class="card-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Categoria</th>
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
						<td><c:out value="${ produto.estoqueMinimo }" /></td>
						<td><c:out value="${ produto.precoVenda }" /></td>
						<td><c:out value="${ produto.precoCompra }" /></td>
						<td>
							<a href="AtualizarProduto?codigo=${ produto.codigo }"><i class="mdi mdi-pencil"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
