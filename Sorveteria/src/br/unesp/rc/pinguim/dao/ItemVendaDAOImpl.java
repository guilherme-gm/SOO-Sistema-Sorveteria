package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.pinguim.models.CategoriaProduto;
import br.unesp.rc.pinguim.models.ItemVenda;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.utils.FabricaConexao;

/**
 * Implementação de persistência de um Item de Venda
 * 
 * Não possui uma interface pois é usado internamente
 */
public class ItemVendaDAOImpl {

	public static final String INSERT_ITEMVENDA = "INSERT INTO ItemVenda (Venda_codigo,Produto_codigo,quantidade,valorUnidade) VALUES (?,?,?,?)";
	public static final String SELECT_ITEMVENDA = "SELECT Venda_codigo, Produto_codigo, quantidade, valorUnidade, nome, categoria "
			+ "FROM Itemvenda " + "JOIN produto on codigo = Produto_codigo " + "WHERE Venda_codigo = ?;";

	public ItemVendaDAOImpl() {
	}

	/**
	 * Salva um item da venda
	 * 
	 * @param con
	 *            : conexão
	 * @param itemVenda
	 *            : item da venda que será salvo
	 * @param idVenda
	 *            : codigo da venda a qual o itemVenda pertence
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

	/**
	 * Retorna uma lista de itens presentes em uma venda por meio do seu codigo
	 *
	 * @param codigo
	 *            : codigo da venda
	 * @return uma lista de ItemVenda cujo código da venda foi dado, ou
	 *         <code>null</code> se não encontrado.
	 */

	public List<ItemVenda> buscarPorCodigoDaVenda(long codigo) {
		List<ItemVenda> itens = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_ITEMVENDA);
				pstm.setLong(1, codigo);
				res = pstm.executeQuery();

				while (res.next()) {
					Produto produto = new Produto();
					produto.setCodigo(res.getLong("Produto_codigo"));
					produto.setCategoria(CategoriaProduto.valueOf(res.getString("categoria")));
					produto.setNome(res.getString("nome"));
					itens.add(new ItemVenda(res.getInt("quantidade"), res.getDouble("valorUnidade"), produto));

				}
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return itens;
	}

}
