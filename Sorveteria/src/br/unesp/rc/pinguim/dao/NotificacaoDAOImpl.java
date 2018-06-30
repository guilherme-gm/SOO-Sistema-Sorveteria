package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.Notificacao;
import br.unesp.rc.pinguim.utils.FabricaConexao;

/**
 * ImplementaÃ§Ã£o da interface NotificaoDAO para persistÃªncia de
 * notificaÃ§Ãµes de estoque
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
				pstm.setInt(3, notificacao.getProduto().getCodigo());

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

}
