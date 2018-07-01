package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.ItemVenda;
import br.unesp.rc.pinguim.models.Venda;
import br.unesp.rc.pinguim.utils.FabricaConexao;

public class VendaDAOImpl implements VendaDAO {

	public VendaDAOImpl() {
	}

	/**
	 * Salva o  pagamento, a venda e os itens da venda.
	 *
	 * @param venda
	 * @return <code>true</code> se salvou, <code>false</code> caso contrário.
	 */
	@Override
	public boolean salvar(Venda venda) {
		Connection con = null;
		boolean b = false;
		con = FabricaConexao.getConexao();
		long idPagamento = -1;
		long idVenda = -1;
		
		if (con != null) {
			try {
				con.setAutoCommit(false);
				/* Pagemento */
				PagamentoDAOImpl pl = new PagamentoDAOImpl();
				idPagamento = pl.salvar(con, venda.getPagamento());

				/* Venda */
				venda.getPagamento().setCodigo(idPagamento);
				idVenda = salvar(con,venda);
				
				/* Itens Venda */

				ItemVendaDAOImpl itemVendaIm = new ItemVendaDAOImpl();
				
				for(ItemVenda item : venda.getItens()) {
					itemVendaIm.salvar(con, item, idVenda);	
				}
				
				
				con.commit();
				b = true;
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return b;
	}

	/**
	 * Salva a venda
	 * @param con : conexão
	 * @param venda : venda que será salva
	 * @return Retorna o codigo da venda
	 * @throws SQLException
	 */
	public long salvar(Connection con, Venda venda) throws SQLException {
		PreparedStatement pstm = null;
		ResultSet res = null;
		long idVenda = -1;

		if (con != null) {
			pstm = con.prepareStatement(INSERT_VENDA, PreparedStatement.RETURN_GENERATED_KEYS);

			pstm.setDouble(1, venda.getTotal());
			pstm.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));
			pstm.setLong(3, venda.getVendedor().getCodigo());
			pstm.setLong(4, venda.getPagamento().getCodigo());
			
			pstm.executeUpdate();
			res = pstm.getGeneratedKeys();
			while (res.next()) {
				idVenda = res.getLong(1);
			}
		}
		return idVenda;
	}

	/**
	 * Retorna uma Venda pelo seu código.
	 *
	 * @param codigo
	 *            código da Venda
	 * @return Venda cujo código foi dado, ou <code>null</code> se não encontrado.
	 */
	@Override
	public Venda buscarPorCodigo(long codigo) {
		Venda venda = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		boolean b = false;
		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_VENDA);
				res = pstm.executeQuery();

				if (res.next()) {

					venda = new Venda();

					venda.setCodigo(pstm.getLong(1));
					venda.setTotal(pstm.getDouble(2));
					venda.setDataVenda(pstm.getDate(3));

				}
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return b;
	}

}
