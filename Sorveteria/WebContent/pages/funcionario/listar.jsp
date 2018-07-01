<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Funcionários</h2>

<div class="card">
	<div class="card-body">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nome</th>
					<th>Endereco</th>
					<th>Contato</th>
					<th>Cpf</th>
					<th>DataNascimento</th>
					<th>Cargo</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${funcionarios}" var="funcionario">
					<tr>
						<td><c:out value="${funcionario.codigo}" /></td>
						<td><c:out value="${funcionario.nome}" /></td>
						<td><c:out value="${funcionario.endereco}" /></td>
						<td><c:out value="${funcionario.contato}" /></td>
						<td><c:out value="${funcionario.cpf}" /></td>
						<td><c:out value="${funcionario.dataNascimento}" /></td>
						<td><c:out value="${funcionario.cargo}" /></td>
						<td><a href="AtualizarFuncionario?codigo=${ produto.codigo }"><i
								class="mdi mdi-pencil"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
