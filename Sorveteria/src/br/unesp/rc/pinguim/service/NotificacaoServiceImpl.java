package br.unesp.rc.pinguim.service;

import java.util.List;

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

	/**
	 * Retorna as ultimas <code>quantidade</code> notificações. Levando em conta
	 * todas ou apenas as não lidas
	 * 
	 * @param quantidade numero de notificações para retornar
	 * @param apenasNovas se deve retornar apenas as não lidas (<code>true</code>)
	 * @return lista de notificações
	 */
	@Override
	public List<Notificacao> listar(int quantidade, boolean apenasNovas) {
		if (apenasNovas) {
			return notificacaoDAO.listarNovas(quantidade);
		} else {
			return notificacaoDAO.listar(quantidade);
		}
	}

}
