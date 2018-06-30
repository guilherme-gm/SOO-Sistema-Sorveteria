package br.unesp.rc.pinguim.service;

import java.util.List;

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

	/**
	 * Retorna as ultimas <code>quantidade</code> notifica��es. Levando em conta
	 * todas ou apenas as n�o lidas
	 * 
	 * @param quantidade numero de notifica��es para retornar
	 * @param apenasNovas se deve retornar apenas as n�o lidas (<code>true</code>)
	 * @return lista de notifica��es
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
