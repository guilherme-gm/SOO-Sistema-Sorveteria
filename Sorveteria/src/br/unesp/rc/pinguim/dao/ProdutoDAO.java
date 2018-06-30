package br.unesp.rc.pinguim.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.Produto;


public interface ProdutoDAO {

    public static final String INSERT_PRODUTO = "INSERT INTO Produto (nome,categoria,estoqueMinimo,precoVenda,precoCompra,) VALUES (?,?,?,?,?,)";
    public boolean salvar(Produto produto);
    public Produto buscarPorCodigo(long codigo);
}
