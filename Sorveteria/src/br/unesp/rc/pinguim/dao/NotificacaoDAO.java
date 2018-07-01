package br.unesp.rc.pinguim.dao;

import java.util.List;

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
	public static final String BUSCAR_NOVAS_NOTIFICACAO = "SELECT Notificacao.codigo, data, lido, Produto_codigo, Produto.codigo, nome FROM Notificacao INNER JOIN Produto ON Produto_codigo = Produto.codigo WHERE lido = 0 ORDER BY data DESC LIMIT ?";
	public static final String BUSCAR_NOTIFICACAO = "SELECT Notificacao.codigo, data, lido, Produto_codigo, Produto.codigo, nome FROM Notificacao INNER JOIN Produto ON Produto_codigo = Produto.codigo ORDER BY data DESC LIMIT ?";

	/**
	 * Salva uma nova notificação no banco de dados
	 * 
	 * @param notificacao
	 *            notificação a ser salva
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contrário
	 */
	public boolean salvar(Notificacao notificacao);

	/**
	 * Marca uma notificação como lida
	 * 
	 * @param id
	 *            : Id da notificação
	 */
	public boolean ler(long id);

	/**
	 * Retorna as ultimas <code>quantidade</code> notificações não lidas.
	 * 
	 * @param quantidade
	 *            numero de notificações para retornar
	 * @return lista de notificações
	 */
	public List<Notificacao> listarNovas(int quantidade);

	/**
	 * Retorna as ultimas <code>quantidade</code> notificações, independente de
	 * lidas ou não
	 * 
	 * @param quantidade
	 *            numero de notificações para retornar
	 * @return lista de notificações
	 */
	public List<Notificacao> listar(int quantidade);

}
