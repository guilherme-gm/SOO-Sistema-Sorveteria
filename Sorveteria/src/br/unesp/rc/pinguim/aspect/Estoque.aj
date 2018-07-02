package br.unesp.rc.pinguim.aspect;

import java.util.Date;

import br.unesp.rc.pinguim.models.Notificacao;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.NotificacaoService;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Aspecto para o controle de estoque
 */
public aspect Estoque {

	/**
	 * Verificação sobre as atualizações de produto para notificar estoques abaixo
	 * do mínimo
	 * 
	 * @param prod
	 *            Produto sendo atualizado
	 */
	after(Produto prod): 
		call(* ProdutoService.atualizar(Produto)) && args(prod) {
		if (prod.getQuantidadeEstoque() <= prod.getEstoqueMinimo()) {
			Notificacao notif = new Notificacao();
			notif.setData(new Date());
			notif.setLido(false);
			notif.setProduto(prod);

			NotificacaoService ns = ServiceFactory.getNotificacaoService();
			ns.salvar(notif);
		}
	}
}
