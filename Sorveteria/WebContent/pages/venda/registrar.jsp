<h2>Registrar Venda</h2>
<div class="card">
	<div class="card-body">
		<h3>Busca</h3>
		<div class="form-row">
			<div class="col">
				<input id="busca-text" type="text" class="form-control"
					placeholder="Busca">
			</div>
			<div class="col">
				<button id="btn-buscar" type="button" class="btn btn-primary">Buscar</button>
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
				<tbody id="table-busca">
				</tbody>

			</table>
		</div>
	</div>
</div>

<br />
<br />
<form method="POST" action="#">

	<div class="card">
		<div class="card-body">
			<h3>Venda</h3>
			<div class="form-group">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Categoria</th>
							<th>Em estoque</th>
							<th>Preço</th>
							<th>Quantidade</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody id="table-venda">
					</tbody>

				</table>
			</div>

			<div class="form-group">
				<div class="float-right">
					<label>Total:</label> R$<span id="total-venda">0,00</span>
				</div>
				<div class="float-none"></div>
			</div>
		</div>
	</div>

	<button type="submit" class="btn btn-primary">Confirmar</button>
</form>

<script src="js/venda.js"></script>