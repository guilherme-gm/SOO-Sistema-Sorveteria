package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.ItemVenda;

public class ItemVendaDAOImpl {

	public static final String INSERT_ITEMVENDA = "INSERT INTO ItemVenda (Venda_codigo,Produto_codigo,quantidade,valorUnidade) VALUES (?,?,?,?)";

	public ItemVendaDAOImpl() {
	}

	/**
	 * Salva um item da venda
	 * @param con :  conexão
	 * @param itemVenda : item da venda que será salvo
	 * @param idVenda : codigo da venda a qual o itemVenda pertence
	 * @return <code>true</code> se salvou, <code>false</code> caso contrário.
	 * @throws SQLException
	 */
	public boolean salvar(Connection con, ItemVenda itemVenda, long idVenda) throws SQLException {
		PreparedStatement pstm = null;
		boolean b = false;

		if (con != null) {
			try {
				pstm = con.prepareStatement(INSERT_ITEMVENDA, PreparedStatement.RETURN_GENERATED_KEYS);

				pstm.setLong(1, idVenda);
				pstm.setLong(2, itemVenda.getProduto().getCodigo());
				pstm.setInt(3, itemVenda.getQuantidade());
				pstm.setDouble(4, itemVenda.getValorUnidade());

				pstm.executeUpdate();
				b = true;
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}
		return b;
	}

	// /**
	// * Retorna uma ItemVenda pelo seu código.
	// *
	// * @param codigo
	// * código da ItemVenda
	// * @return ItemVenda cujo código foi dado, ou <code>null</code> se não
	// * encontrado.
	// */
	// @Override
	// public ItemVenda buscarPorCodigo(long codigo) {
	// ItemVenda itemVenda = null;
	// Connection con = null;
	// PreparedStatement pstm = null;
	// ResultSet res = null;
	// boolean b = false;
	// con = FabricaConexao.getConexao();
	//
	// if (con != null) {
	// try {
	// pstm = con.prepareStatement(SELECT_ITEMVENDA);
	// res = pstm.executeQuery();
	//
	// if (res.next()) {
	//
	// itemVenda = new ItemVenda();
	//
	// itemVenda.setQuantidade(pstm.getInt(1));
	// itemVenda.setValorUnidade(pstm.getDouble(2));
	//
	// }
	// } catch (SQLException ex) {
	// System.out.println("Message: " + ex.getMessage());
	// }
	// }
	//
	// return b;
	// }
	//
}
