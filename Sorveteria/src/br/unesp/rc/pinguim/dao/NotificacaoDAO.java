package br.unesp.rc.pinguim.dao;

import br.unesp.rc.pinguim.models.Notificacao;

/**
 * Interface para persistência de Notificações
 * 
 * @author guilh
 *
 */
public interface NotificacaoDAO {

	public static final String INSERT_NOTIFICACAO = "INSERT INTO Notificacao (data, lido, Produto_codigo) VALUES (?, ?, ?);";

	/**
	 * Salva uma nova notificação no banco de dados
	 * 
	 * @param notificacao
	 *            notificação a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contrário
	 */
	public boolean salvar(Notificacao notificacao);

}
