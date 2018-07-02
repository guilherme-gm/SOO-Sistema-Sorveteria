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
	 * Página pronta
	 */
	$( document ).ready(function() {
		requisitaNotificacoes();
		window.setInterval(function(){
			  requisitaNotificacoes();
			}, 30000);
	});

});

function requisitaNotificacoes() {
	$.get("ListarNotificacoes", {
		novas : true
	}).done(listaNotificacoes).fail(function() {
		alert("Ocorreu um erro ao realizar a busca. Tente novamente.");
	});
}

function listaNotificacoes(data) {
	let json = JSON.parse(data);
	let area = $("#notificacoes");
	let contador = 0;
	area.empty();
	json.forEach(function(notif) {
		area.append(
				'<a class="dropdown-item preview-item" id="notif-'+notif.codigo+'">' +
					'<div class="preview-thumbnail">' +
						'<div class="preview-icon bg-success">' +
							'<i class="mdi mdi-alert-circle-outline mx-0"></i>' +
					    '</div>' +
					 '</div>' +
					 '<div class="preview-item-content">' +
					 	'<h6 class="preview-subject font-weight-medium text-dark">'+ notif.produto.nome + ' abaixo do estoque.</h6>' +
					 	'<p class="font-weight-light small-text">' + notif.data + '</p>' +
					 '</div>' +
					 '<div class="preview-item-content">' +
					 	'<button class="btn btn-outline-primary" href="#" onclick="lerNotificacao('+notif.codigo+')"><i class="mdi mdi-checkbox-marked-circle-outline"></i></button>' +
					 '</div>' +
				'</a>'
		);
		
		contador++;
	});
		
	$("#notif-msg-count").text(contador);
	$("#notif-count").text(contador);
	if (contador > 0) {
		$("#notif-count").removeClass('d-none');
	} else {
		$("#notif-count").addClass('d-none');
	}
}

function lerNotificacao(id) {
	$.post("LerNotificacao", {
		idNotificacao: id
	}).done(function(data) {
		json = JSON.parse(data);
		if (json == true) {
			$("#notif-"+id).remove();
			requisitaNotificacoes();
		} else {
			alert("Ocorreu um erro ao realizar ao marcar a notificação como lida. Tente novamente.");
		}
	}).fail(function() {
		alert("Ocorreu um erro ao realizar ao marcar a notificação como lida. Tente novamente.");
	});
}
