package br.unesp.rc.pinguim.dao;

import java.util.List;

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
	public static final String BUSCAR_NOVAS_NOTIFICACAO = "SELECT Notificacao.codigo, data, lido, Produto_codigo, Produto.codigo, nome FROM Notificacao INNER JOIN Produto ON Produto_codigo = Produto.codigo WHERE lido = 0 ORDER BY data DESC LIMIT ?";
	public static final String BUSCAR_NOTIFICACAO = "SELECT Notificacao.codigo, data, lido, Produto_codigo, Produto.codigo, nome FROM Notificacao INNER JOIN Produto ON Produto_codigo = Produto.codigo ORDER BY data DESC LIMIT ?";

	/**
	 * Salva uma nova notifica��o no banco de dados
	 * 
	 * @param notificacao
	 *            notifica��o a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contr�rio
	 */
	public boolean salvar(Notificacao notificacao);

	/**
	 * Marca uma notifica��o como lida
	 * 
	 * @param id
	 *            : Id da notifica��o
	 */
	public boolean ler(long id);

	/**
	 * Retorna as ultimas <code>quantidade</code> notifica��es n�o lidas.
	 * 
	 * @param quantidade
	 *            numero de notifica��es para retornar
	 * @return lista de notifica��es
	 */
	public List<Notificacao> listarNovas(int quantidade);

	/**
	 * Retorna as ultimas <code>quantidade</code> notifica��es, independente de
	 * lidas ou n�o
	 * 
	 * @param quantidade
	 *            numero de notifica��es para retornar
	 * @return lista de notifica��es
	 */
	public List<Notificacao> listar(int quantidade);

}
