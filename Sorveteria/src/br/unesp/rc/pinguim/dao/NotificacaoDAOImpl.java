package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.Notificacao;
import br.unesp.rc.pinguim.utils.FabricaConexao;

/**
 * Implementação da interface NotificaoDAO para persistência de notificações de
 * estoque
 */
public class NotificacaoDAOImpl implements NotificacaoDAO {

	public NotificacaoDAOImpl() {
	}

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

}
