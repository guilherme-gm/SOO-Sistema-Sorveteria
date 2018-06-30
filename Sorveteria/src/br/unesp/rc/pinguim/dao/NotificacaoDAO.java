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
	public static final String LER_NOTIFICACAO = "UPDATE Notificacao SET lido = 1 WHERE codigo = ?;";

	/**
	 * Salva uma nova notificação no banco de dados
	 * 
	 * @param notificacao
	 *            notificação a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contrário
	 */
	public boolean salvar(Notificacao notificacao);

	public boolean ler(long id);

}
