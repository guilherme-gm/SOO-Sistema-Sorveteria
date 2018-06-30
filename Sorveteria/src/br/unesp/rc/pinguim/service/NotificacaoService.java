package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Notificacao;

/**
 * Service para manipula��o da classe Notifica��o
 */
public interface NotificacaoService {

	/**
	 * Salva uma Notifica��o
	 * 
	 * @param notificacao
	 *            : Notifica��o a ser salva
	 * @return <code>true</code> se salvou com sucesso. <code>false</code> caso
	 *         contr�rio.
	 */
	public boolean salvar(Notificacao notificacao);

}
