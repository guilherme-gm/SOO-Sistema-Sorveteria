package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unesp.rc.pinguim.models.Produto;

public interface ProdutoDAO {

	public static final String INSERT_PRODUTO = "INSERT INTO Produto (nome,categoria,quantidadeEstoque,estoqueMinimo,precoVenda,precoCompra) VALUES (?,?,?,?,?,?,)";
	public static final String SELECT_PRODUTO_BY_CODIGO = "SELECT codigo, nome, categoria, quantidadeEstoque, estoqueMinimo, precoVenda, precoCompra "
			+ "FROM Produto " + "WHERE codigo = ? ;";
	public static final String SELECT_PRODUTO_BY_NOME = "SELECT codigo, nome, categoria, quantidadeEstoque, estoqueMinimo, precoVenda, precoCompra "
			+ "FROM Produto " + "WHERE nome = ? ;";

	public static final String SELECT_PRODUTO = "SELECT codigo, nome, categoria, quantidadeEstoque, estoqueMinimo, precoVenda, precoCompra "
			+ "FROM Produto ";

	public static final String UPDATE_PRODUTO = "UPDATE produto SET nome  = ?,  categoria  = ?,  quantidadeEstoque  = ?,  estoqueMinimo  = ?, precoVenda  = ?, precoCompra  = ? WHERE  codigo  = ?;";
	
	public boolean salvar(Produto produto);

	public Produto buscarPorCodigo(long codigo);

	public Produto BuscarPorNome(String nome);

	public List<Produto> BuscarTodos();

	public boolean AtualizarProduto(Produto produto);
}
