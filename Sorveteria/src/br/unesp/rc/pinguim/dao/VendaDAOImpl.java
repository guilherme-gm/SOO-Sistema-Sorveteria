package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.models.ItemVenda;
import br.unesp.rc.pinguim.models.Pagamento;
import br.unesp.rc.pinguim.models.Venda;
import br.unesp.rc.pinguim.utils.FabricaConexao;

/**
 * Classe de persistência de Vendas
 */
public class VendaDAOImpl implements VendaDAO {

	public VendaDAOImpl() {
	}

	/**
	 * Salva o pagamento, a venda e os itens da venda.
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
				idVenda = salvar(con, venda);
				venda.setCodigo(idVenda);

				/* Itens Venda */

				ItemVendaDAOImpl itemVendaIm = new ItemVendaDAOImpl();

				for (ItemVenda item : venda.getItens()) {
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
	 * 
	 * @param con
	 *            : conexão
	 * @param venda
	 *            : venda que será salva
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
	 * Retorna uma lista com todas as vendas
	 * 
	 * @return Retorna uma lista de vendas
	 */
	@Override
	public List<Venda> BuscarTodos() {
		List<Venda> vendas = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_VENDA);
				res = pstm.executeQuery();

				while (res.next()) {
					Venda venda = new Venda();

					venda.setCodigo(res.getLong("v.codigo"));
					venda.setDataVenda(res.getDate("dataVenda"));
					venda.setTotal(res.getDouble("total"));
					venda.setPagamento(new Pagamento(res.getString("p.metodoPagamento")));
					Funcionario vendedor = new Funcionario();
					vendedor.setNome(res.getString("f.nome"));
					venda.setVendedor(vendedor);

					ItemVendaDAOImpl itemImpl = new ItemVendaDAOImpl();
					List<ItemVenda> itens = itemImpl.buscarPorCodigoDaVenda(res.getLong("v.codigo"));

					venda.setItens(itens);
					vendas.add(venda);
				}

			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return vendas;

	}

}
