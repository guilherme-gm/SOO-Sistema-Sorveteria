package br.unesp.rc.pinguim.dao;

import br.unesp.rc.pinguim.models.Notificacao;

/**
 * Interface para persist�ncia de Notifica��es
 * 
 * @author guilh
 *
 */
public interface NotificacaoDAO {

	public static final String INSERT_NOTIFICACAO = "INSERT INTO Notificacao (data, lido, Produto_codigo) VALUES (?, ?, ?);";

	/**
	 * Salva uma nova notifica��o no banco de dados
	 * 
	 * @param notificacao
	 *            notifica��o a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contr�rio
	 */
	public boolean salvar(Notificacao notificacao);

}
