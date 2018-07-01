<h2>Atualizar Produto</h2>
<form method="POST" action="DoAtualizarProduto">
	<input type="hidden" name="codigo" value="${ produto.codigo }" />
	<div class="form-group">
		<label for="nome">Nome</label> <input type="text" class="form-control"
			name="nome" id="nome" placeholder="Nome" value="${ produto.nome }">
	</div>
	<div class="form-group">
		<label for="categoria">Categoria</label> <select name="categoria"
			id="categoria" class="form-control">
			<option value="PICOLE"
				${ produto.categoria eq 'PICOLE' ? 'selected' : '' }>Picolé</option>
			<option value="MASSA"
				${ produto.categoria eq 'MASSA' ? 'selected' : '' }>Massa</option>
		</select>
	</div>
	<div class="form-group">
		<label for="quantidadeEstoque">Estoque Atual</label> <input
			type="number" class="form-control" name="quantidadeEstoque"
			id="quantidadeEstoque" placeholder="Estoque Atual"
			value="${ produto.quantidadeEstoque }" min="0">
	</div>
	<div class="form-group">
		<label for="estoqueMinimo">Estoque Mínimo</label> <input type="number"
			class="form-control" name="estoqueMinimo" id="estoqueMinimo"
			placeholder="Estoque Mínimo" value="${ produto.estoqueMinimo }"
			min="0">
	</div>
	<div class="form-group">
		<label for="precoCompra">Preço Compra</label> <input type="text"
			class="form-control" name="precoCompra" id="precoCompra"
			placeholder="Preço Compra" value="${ produto.precoCompra }">
	</div>
	<div class="form-group">
		<label for="precoVenda">Preço Venda</label> <input type="text"
			class="form-control" name="precoVenda" id="precoVenda"
			placeholder="Preço Venda" value="${ produto.precoVenda }">
	</div>

	<button type="reset" class="btn btn-primary">Redefinir</button>
	<button type="submit" class="btn btn-primary">Atualizar</button>
</form>