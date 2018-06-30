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

	@Override
	public boolean salvar(Notificacao notificacao) {
		return notificacaoDAO.salvar(notificacao);
	}

}
