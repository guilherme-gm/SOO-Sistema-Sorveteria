package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.pinguim.models.Notificacao;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.utils.FabricaConexao;

/**
 * Implementação da interface NotificaoDAO para persistência de notificações de
 * estoque
 */
public class NotificacaoDAOImpl implements NotificacaoDAO {

	public NotificacaoDAOImpl() {
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
		Connection con = null;
		PreparedStatement pstm = null;
		boolean b = false;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(INSERT_NOTIFICACAO);

				pstm.setDate(1, new java.sql.Date(notificacao.getData().getTime()));
				pstm.setBoolean(2, notificacao.isLido());
				pstm.setLong(3, notificacao.getProduto().getCodigo());

				pstm.executeUpdate();
				b = true;
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return b;
	}

	/**
	 * Marca uma notificação como lida
	 * 
	 * @param id
	 *            : Id da notificação
	 */
	@Override
	public boolean ler(long id) {
		Connection con = null;
		PreparedStatement pstm = null;
		boolean b = false;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(LER_NOTIFICACAO);

				pstm.setLong(1, id);

				pstm.executeUpdate();
				b = true;
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return b;
	}

	/**
	 * Retorna as ultimas <code>quantidade</code> notificações não lidas.
	 * 
	 * @param quantidade
	 *            numero de notificações para retornar
	 * @return lista de notificações
	 */
	@Override
	public List<Notificacao> listarNovas(int quantidade) {
		return listar(BUSCAR_NOVAS_NOTIFICACAO, quantidade);
	}

	/**
	 * Retorna as ultimas <code>quantidade</code> notificações.
	 * 
	 * @param quantidade
	 *            numero de notificações para retornar
	 * @return lista de notificações
	 */
	@Override
	public List<Notificacao> listar(int quantidade) {
		return listar(BUSCAR_NOTIFICACAO, quantidade);
	}

	/**
	 * Retorna as ultimas <code>quantidade</code> notificações a partir da query
	 * dada. Este método envolve as buscas da interface
	 * 
	 * @param query
	 *            Consulta a ser utilizada
	 * @param quantidade
	 *            numero de notificações para retornar
	 * @return lista de notificações
	 */
	private List<Notificacao> listar(String query, int quantidade) {
		Connection con = null;
		PreparedStatement pstm = null;
		List<Notificacao> notificacoes = new ArrayList<>();
		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				ResultSet res = null;
				pstm = con.prepareStatement(query);
				pstm.setInt(1, quantidade);
				res = pstm.executeQuery();

				while (res.next()) {
					Notificacao n = new Notificacao();
					n.setCodigo(res.getLong("codigo"));
					n.setData(res.getDate("data"));
					n.setLido(res.getBoolean("lido"));

					Produto p = new Produto();
					p.setCodigo(res.getLong("Produto_codigo"));
					p.setNome(res.getString("nome"));
					n.setProduto(p);

					notificacoes.add(n);
				}
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return notificacoes;
	}

}
