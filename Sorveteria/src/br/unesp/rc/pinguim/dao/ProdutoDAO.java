package br.unesp.rc.pinguim.dao;

import java.util.List;

import br.unesp.rc.pinguim.models.Produto;

/**
 * Interface para persistência de produtos
 */
public interface ProdutoDAO {

	public static final String INSERT_PRODUTO = "INSERT INTO Produto (nome,categoria,quantidadeEstoque,estoqueMinimo,precoVenda,precoCompra) VALUES (?,?,?,?,?,?)";
	public static final String SELECT_PRODUTO_BY_CODIGO = "SELECT codigo, nome, categoria, quantidadeEstoque, estoqueMinimo, precoVenda, precoCompra "
			+ "FROM Produto " + "WHERE codigo = ? ;";
	public static final String SELECT_PRODUTO_BY_NOME = "SELECT codigo, nome, categoria, quantidadeEstoque, estoqueMinimo, precoVenda, precoCompra "
			+ "FROM Produto " + "WHERE nome LIKE ? ;";

	public static final String SELECT_PRODUTO = "SELECT codigo, nome, categoria, quantidadeEstoque, estoqueMinimo, precoVenda, precoCompra FROM Produto ";

	public static final String UPDATE_PRODUTO = "UPDATE produto SET nome  = ?,  categoria  = ?,  quantidadeEstoque  = ?,  estoqueMinimo  = ?, precoVenda  = ?, precoCompra  = ? WHERE  codigo  = ?;";

	/**
	 * Insere um novo produto
	 * 
	 * @param produto
	 * @return
	 */
	public boolean salvar(Produto produto);

	/**
	 * Busa um produto a partir de seu código
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto buscarPorCodigo(long codigo);

	/**
	 * Busca os produtos a partir de parte do nome
	 * 
	 * @param nome
	 * @return
	 */
	public List<Produto> buscarPorNome(String nome);

	/**
	 * Retorna todos os produtos
	 * 
	 * @return
	 */
	public List<Produto> buscarTodos();

	/**
	 * Atualiza um Produto
	 * 
	 * @param produto
	 * @return
	 */
	public boolean atualizar(Produto produto);
}
