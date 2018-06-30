package br.unesp.rc.pinguim.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.CategoriaProduto;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.utils.FabricaConexao;


public class ProdutoDAOImpl implements ProdutoDAO {

    public ProdutoDAOImpl() {}

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

                pstm.setLong(1, produto.getCodigo());
                pstm.setString(2, produto.getNome());
                pstm.setString(3,produto.getCategoria().toString());
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
     * @param codigo código do Produto
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
                    produto.setPrecoVenda(res.getDouble("precoVenda"));
                    produto.setPrecoCompra(res.getDouble("precoCompra"));

                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }
        
        return produto;
    }

}
