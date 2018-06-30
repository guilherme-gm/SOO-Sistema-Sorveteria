package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Notificacao;

/**
 * Service para manipulação da classe Notificação
 */
public interface NotificacaoService {

	/**
	 * Salva uma Notificação
	 * 
	 * @param notificacao
	 *            : Notificação a ser salva
	 * @return <code>true</code> se salvou com sucesso. <code>false</code> caso
	 *         contrário.
	 */
	public boolean salvar(Notificacao notificacao);

	/**
	 * Marca uma notificação como lida
	 * 
	 * @param id
	 *            ID da notificação
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contrário
	 */
	public boolean ler(long id);

}
