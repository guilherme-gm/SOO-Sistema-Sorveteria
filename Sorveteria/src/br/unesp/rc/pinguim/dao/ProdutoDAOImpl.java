package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.pinguim.models.CategoriaProduto;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.utils.FabricaConexao;

public class ProdutoDAOImpl implements ProdutoDAO {

	public ProdutoDAOImpl() {
	}

	/**
	 * Salva um Produto.
	 *
	 * @param produto
	 * @return <code>true</code> se salvou, <code>false</code> caso contr�rio.
	 */
	@Override
	public boolean salvar(Produto produto) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		boolean b = false;
		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				con.setAutoCommit(false);

				pstm = con.prepareStatement(INSERT_PRODUTO, PreparedStatement.RETURN_GENERATED_KEYS);

				pstm.setLong(1, produto.getCodigo());
				pstm.setString(2, produto.getNome());
				pstm.setString(3, produto.getCategoria().toString());
				pstm.setInt(4, produto.getEstoqueMinimo());
				pstm.setDouble(5, produto.getPrecoVenda());
				pstm.setDouble(6, produto.getPrecoCompra());

				pstm.executeUpdate();

				con.commit();
				b = true;
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return b;
	}

	/**
	 * Retorna um Produto pelo seu c�digo.
	 *
	 * @param codigo
	 *            c�digo do Produto
	 * @return Produto cujo c�digo foi dado, ou <code>null</code> se n�o encontrado.
	 */
	@Override
	public Produto buscarPorCodigo(long codigo) {
		Produto produto = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_PRODUTO_BY_CODIGO);
				pstm.setLong(1, codigo);
				res = pstm.executeQuery();

				if (res.next()) {

					produto = new Produto();

					produto.setCodigo(res.getLong("codigo"));
					produto.setNome(res.getString("nome"));
					produto.setEstoqueMinimo(res.getInt("estoqueMinimo"));
					produto.setPrecoVenda(res.getDouble("precoVenda"));
					produto.setPrecoCompra(res.getDouble("precoCompra"));
					produto.setCategoria(CategoriaProduto.valueOf(res.getString("Categoria")));
				}
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return produto;
	}

	/**
	 * Busca um Produto a partir do seu nome
	 * 
	 * @param nome
	 *            : nome do Produto
	 * @return Produto com o nome correspondente ou <code>null</code> se n�o
	 *         encontrado.
	 */
	@Override
	public Produto BuscarPorNome(String nome) {
		Produto produto = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_PRODUTO_BY_NOME);
				pstm.setString(1, nome);
				res = pstm.executeQuery();

				if (res.next()) {

					produto = new Produto();

					produto.setCodigo(res.getLong("codigo"));
					produto.setNome(res.getString("nome"));
					produto.setEstoqueMinimo(res.getInt("estoqueMinimo"));
					produto.setPrecoVenda(res.getDouble("precoVenda"));
					produto.setPrecoCompra(res.getDouble("precoCompra"));
					produto.setCategoria(CategoriaProduto.valueOf(res.getString("Categoria")));
				}
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return produto;
	}

	/**
	 * Busca todos os produtos
	 * 
	 * @return Uma lista de produtos
	 */
	@Override
	public List<Produto> BuscarTodos() {
		List<Produto> produtos = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_PRODUTO);
				res = pstm.executeQuery();

				while (res.next()) {
					Produto produto = new Produto();
					produto.setCodigo(res.getLong("codigo"));
					produto.setNome(res.getString("nome"));
					produto.setCategoria(CategoriaProduto.valueOf(res.getString("categoria")));
					produto.setEstoqueMinimo(res.getInt("estoqueMinimo"));
					produto.setPrecoCompra(res.getDouble("precoCompra"));
					produto.setPrecoVenda(res.getDouble("precoVenda"));
					produtos.add(produto);
				}

			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return produtos;
	}

}