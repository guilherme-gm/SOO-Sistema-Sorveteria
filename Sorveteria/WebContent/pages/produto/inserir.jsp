
<h2>Inserir Produto</h2>
<form method="POST" action="#">
	<div class="form-group">
		<label for="nome">Nome</label> <input type="text" class="form-control"
			name="nome" id="nome" placeholder="Nome" value="">
	</div>
	<div class="form-group">
		<label for="categoria">Categoria</label> <select name="categoria"
			id="categoria" class="form-control">
			<option value="PICOLE">Picol�</option>
			<option value="MASSA">Massa</option>
		</select>
	</div>
	<div class="form-group">
		<label for="estoqueMinimo">Estoque M�nimo</label> <input type="number"
			class="form-control" name="estoqueMinimo" id="estoqueMinimo"
			placeholder="Estoque M�nimo" value="" min="0">
	</div>
	<div class="form-group">
		<label for="precoCompra">Pre�o Compra</label> <input type="text"
			class="form-control" name="precoCompra" id="precoCompra"
			placeholder="Pre�o Compra" value="">
	</div>
	<div class="form-group">
		<label for="precoVenda">Pre�o Venda</label> <input type="text"
			class="form-control" name="precoVenda" id="precoVenda"
			placeholder="Pre�o Venda" value="">
	</div>

	<button type="reset" class="btn btn-primary">Limpar</button>
	<button type="submit" class="btn btn-primary">Inserir</button>
</form>