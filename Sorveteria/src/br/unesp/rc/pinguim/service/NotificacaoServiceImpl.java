package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.NotificacaoDAO;
import br.unesp.rc.pinguim.models.Notificacao;

public class NotificacaoServiceImpl implements NotificacaoService {

	private NotificacaoDAO notificacaoDAO;

	/**
	 * Inicializa o service com uma instância do DAO usado
	 */
	public NotificacaoServiceImpl() {
		this.notificacaoDAO = DAOFactory.getNotificacaoDAO();
	}

	/**
	 * Salva uma notificação
	 * 
	 * @param notificacao
	 *            Notificação a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contrário
	 */
	@Override
	public boolean salvar(Notificacao notificacao) {
		return notificacaoDAO.salvar(notificacao);
	}

	/**
	 * Marca uma notificação como lida
	 * 
	 * @param id
	 *            : Id da notificação
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contrário
	 */
	@Override
	public boolean ler(long id) {
		return notificacaoDAO.ler(id);
	}

}
