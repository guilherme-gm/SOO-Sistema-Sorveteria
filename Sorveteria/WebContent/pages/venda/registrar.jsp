<h2>Registrar Venda</h2>
<form method="POST" action="#">
	<div class="card">
		<div class="card-body">
			<h3>Busca</h3>
			<div class="form-row">
				<div class="col">
					<input type="text" class="form-control" placeholder="Busca">
				</div>
				<div class="col">
					<button id="btn-buscar" class="btn btn-primary">Buscar</button>
				</div>
			</div>
			<div class="form-group">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Categoria</th>
							<th>Estoque</th>
							<th>Preço</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody class="items-busca">
						<tr>
							<td>Nap</td>
							<td>MAssa</td>
							<td>10</td>
							<td>R$10</td>
							<td>+</td>
						</tr>
					</tbody>

				</table>
			</div>
		</div>
	</div>

	<br /> <br />

	<div class="card">
		<div class="card-body">
			<h3>Venda</h3>
			<div class="form-group">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Categoria</th>
							<th>Quantidade</th>
							<th>Preço</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody class="items-venda">
						<tr>
							<td>Nap</td>
							<td>MAssa</td>
							<td>10</td>
							<td>R$10</td>
							<td>-</td>
						</tr>
					</tbody>

				</table>
			</div>

			<div class="form-group float-right">
				<label>Total:</label> R$<span id="total-venda">0,00</span>
			</div>
			<div class="float-none"></div>
		</div>
	</div>

	<button type="reset" class="btn btn-primary">Limpar</button>
	<button type="submit" class="btn btn-primary">Confirmar</button>
</form>

<script src="js/venda.js"></script>