<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Relat�rio de Vendas</h2>
<a href="#" class="print-btn"><i class="mdi mdi-printer"></i>
	Imprimir</a>
<br />
<br />

<div class="card">
	<div class="card-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Data</th>
					<th>Total</th>
					<th>Funcion�rio</th>
					<th>M�todo de Pagamento</th>
					<th>Itens</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${vendas}" var="venda">
					<tr>
						<td><c:out value="${venda.codigo}" /></td>
						<td><c:out value="${venda.dataVenda}" /></td>
						<td><c:out value="${venda.total}" /></td>
						<td><c:out value="${venda.vendedor.nome}" /></td>
						<td><c:out value="${venda.pagamento.metodoPagamento}" /></td>
						<td><c:forEach items="${venda.itens}" var="item">
								<ul>
									<li><c:out value="${ item.produto.nome }" /> x<c:out
											value="${ item.quantidade }" /></li>
								</ul>

							</c:forEach>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
