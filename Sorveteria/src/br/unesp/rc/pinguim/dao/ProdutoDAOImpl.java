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
	 * @return <code>true</code> se salvou, <code>false</code> caso contrário.
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

				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getCategoria().toString());
				pstm.setInt(3, produto.getQuantidadeEstoque());
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
	 * Retorna um Produto pelo seu código.
	 *
	 * @param codigo
	 *            código do Produto
	 * @return Produto cujo código foi dado, ou <code>null</code> se não encontrado.
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
					produto.setQuantidadeEstoque(res.getInt("quantidadeEstoque"));
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
	 * Busca os Produto a partir de parte de seu nome
	 * 
	 * @param nome
	 *            : nome do Produto
	 * @return Produtos com o nome correspondente
	 */
	@Override
	public List<Produto> BuscarPorNome(String nome) {
		List<Produto> produtos = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_PRODUTO_BY_NOME);
				pstm.setString(1, nome);
				res = pstm.executeQuery();

				while (res.next()) {

					Produto produto = new Produto();

					produto.setCodigo(res.getLong("codigo"));
					produto.setNome(res.getString("nome"));
					produto.setEstoqueMinimo(res.getInt("estoqueMinimo"));
					produto.setQuantidadeEstoque(res.getInt("quantidadeEstoque"));
					produto.setPrecoVenda(res.getDouble("precoVenda"));
					produto.setPrecoCompra(res.getDouble("precoCompra"));
					produto.setCategoria(CategoriaProduto.valueOf(res.getString("Categoria")));

					produtos.add(produto);
				}
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return produtos;
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
					produto.setQuantidadeEstoque(res.getInt("quantidadeEstoque"));
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

	/**
	 * Atualiza umm determinado produto
	 * 
	 * @param produto
	 *            : Produto que será ataualizado
	 * @return <code>true</code> se atualizou com sucesso. <code>false</code> caso
	 *         contrário.
	 */
	@Override
	public boolean AtualizarProduto(Produto produto) {

		Connection con = FabricaConexao.getConexao();
		PreparedStatement pstm = null;
		boolean b = false;

		if (con != null) {
			try {
				pstm = con.prepareStatement(UPDATE_PRODUTO);

				pstm.setString(1, produto.getNome());
				pstm.setString(2, produto.getCategoria().toString());
				pstm.setInt(3, produto.getQuantidadeEstoque());
				pstm.setInt(4, produto.getEstoqueMinimo());
				pstm.setDouble(5, produto.getPrecoVenda());
				pstm.setDouble(6, produto.getPrecoCompra());
				pstm.setLong(7, produto.getCodigo());
				pstm.executeUpdate();

				b = true;
			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}
		return b;
	}

}
