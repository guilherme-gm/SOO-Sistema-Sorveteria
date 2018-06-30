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
	public static final String LER_NOTIFICACAO = "UPDATE Notificacao SET lido = 1 WHERE codigo = ?;";

	/**
	 * Salva uma nova notifica��o no banco de dados
	 * 
	 * @param notificacao
	 *            notifica��o a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contr�rio
	 */
	public boolean salvar(Notificacao notificacao);

	public boolean ler(long id);

}
