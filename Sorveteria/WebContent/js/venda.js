/**
 * Atrasa a execução de um método para quando o jQuery estiver disponível
 * 
 * @param method
 * @returns
 */
function defer(method) {
	if (window.jQuery) {
		method();
	} else {
		setTimeout(function() {
			defer(method)
		}, 50);
	}
}

/**
 * Adiciona uma coluna na linha row, com o valor data, podendo ser oculta
 * 
 * @param row
 * @param data
 * @param visible
 * @returns
 */
function makeCell(row, data, visible = true) {
	let cel = row.insertCell();
	cel.innerHTML = data;
	if (visible == false) {
		cel.style.display = "none";
	}
}

/**
 * Carregamento das funções que dependem do jQuery
 * 
 * @returns
 */
defer(function() {

	/**
	 * Pressionar enter no campo de busca
	 */
	$("#busca-text").on("keydown", function(event) {
		if (event.keyCode == 13) {
			buscarProduto();
		}
	});

	/**
	 * Botão de Busca
	 */
	$("#btn-buscar").on("click", buscarProduto);

});

/**
 * Busca o termo na caixa de busca
 * 
 * @returns
 */
function buscarProduto() {
	let termo = $("#busca-text").val();

	$.get("BuscaProdutoPorNome", {
		nome : termo
	}).done(preencheResultado).fail(function() {
		alert("Ocorreu um erro ao realizar a busca. Tente novamente.");
	});
}

/**
 * Preenche a área de resultado da busca
 * 
 * @param data
 * @returns
 */
function preencheResultado(data) {
	let old_tbody = document.getElementById("table-busca");
	let new_tbody = document.createElement('tbody');
	new_tbody.id = "table-busca";
	
	json = JSON.parse(data);
	json.forEach(function(prod) {
		let row = new_tbody.insertRow();
		row.id = "busca-" + prod.codigo; 
		makeCell(row, prod.nome);
		makeCell(row, prod.categoria);
		makeCell(row, prod.quantidadeEstoque);
		makeCell(row, prod.precoVenda);
		makeCell(row, '<button class="btn btn-success" onclick="adicionarItemVenda(' + prod.codigo + ')"><i class="mdi mdi-plus"></i></button>');
	});
	
	old_tbody.parentNode.replaceChild(new_tbody, old_tbody)
}

/**
 * Adiciona um item na venda
 * 
 * @param id
 * @returns
 */
function adicionarItemVenda(id) {
	let info = $("#busca-"+id);
	
	if (info.length <= 0 || $("#item-"+id).length > 0) {
		return;
	}
	
	let tbody = document.getElementById("table-venda");
	let row = tbody.insertRow();
	row.id = "item-"+id;
	makeCell(row, info[0].cells[0].innerText); // nome
	makeCell(row, info[0].cells[1].innerText); // categoria
	makeCell(row, info[0].cells[2].innerText); // Estoque
	makeCell(row, info[0].cells[3].innerText); // Preço
	makeCell(row, '<input type="number" name="quantidade" value="1" min="1" onchange="quantidadeMudou()" max="'+info[0].cells[2].innerText+'" />'); // Quantidade
	makeCell(row, '<button class="btn btn-danger" onclick="removerItemVenda(' + id + ')"><i class="mdi mdi-minus"></i></button>');
	makeCell(row, '<input type="hidden" name="produto" value="'+id+'" />', false); // ID
																					// (hidden)
	
	quantidadeMudou();
}

/**
 * Quantidade de um item mudou
 * 
 * @param id
 * @returns
 */
function quantidadeMudou() {
	let tbody = $("#table-venda tr");
	let total = 0.0;
	tbody.each(function (i, row) {
		let r = $(row),
        	qtd = parseInt(r.find('input[name*="quantidade"]').val()),
        	preco = row.cells[3].innerText;
		
		total += preco * qtd;
	});
	
	$("#total-venda").text(total);
}

/**
 * Remove um item dos itens da venda
 * 
 * @param id
 * @returns
 */
function removerItemVenda(id) {
	let item = $("#item-"+id);
	
	if (item.length <= 0) {
		return;
	}
	
	quantidadeMudou();
	
	item.remove();
}