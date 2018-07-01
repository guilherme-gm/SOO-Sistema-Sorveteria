
<h2>Inserir Produto</h2>
<form method="POST" action="#">
	<div class="form-group">
		<label for="nome">Nome</label> <input type="text" class="form-control"
			name="nome" id="nome" placeholder="Nome" value="">
	</div>
	<div class="form-group">
		<label for="categoria">Categoria</label> <select name="categoria"
			id="categoria" class="form-control">
			<option value="PICOLE">Picolé</option>
			<option value="MASSA">Massa</option>
		</select>
	</div>
	<div class="form-group">
		<label for="estoqueMinimo">Estoque Mínimo</label> <input type="number"
			class="form-control" name="estoqueMinimo" id="estoqueMinimo"
			placeholder="Estoque Mínimo" value="" min="0">
	</div>
	<div class="form-group">
		<label for="precoCompra">Preço Compra</label> <input type="text"
			class="form-control" name="precoCompra" id="precoCompra"
			placeholder="Preço Compra" value="">
	</div>
	<div class="form-group">
		<label for="precoVenda">Preço Venda</label> <input type="text"
			class="form-control" name="precoVenda" id="precoVenda"
			placeholder="Preço Venda" value="">
	</div>

	<button type="reset" class="btn btn-primary">Limpar</button>
	<button type="submit" class="btn btn-primary">Inserir</button>
</form>