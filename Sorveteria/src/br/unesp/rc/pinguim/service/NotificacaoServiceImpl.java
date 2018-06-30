package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.NotificacaoDAO;
import br.unesp.rc.pinguim.models.Notificacao;

public class NotificacaoServiceImpl implements NotificacaoService {

	private NotificacaoDAO notificacaoDAO;

	/**
	 * Inicializa o service com uma inst�ncia do DAO usado
	 */
	public NotificacaoServiceImpl() {
		this.notificacaoDAO = DAOFactory.getNotificacaoDAO();
	}

	/**
	 * Salva uma notifica��o
	 * 
	 * @param notificacao
	 *            Notifica��o a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contr�rio
	 */
	@Override
	public boolean salvar(Notificacao notificacao) {
		return notificacaoDAO.salvar(notificacao);
	}

	/**
	 * Marca uma notifica��o como lida
	 * 
	 * @param id
	 *            : Id da notifica��o
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contr�rio
	 */
	@Override
	public boolean ler(long id) {
		return notificacaoDAO.ler(id);
	}

}
