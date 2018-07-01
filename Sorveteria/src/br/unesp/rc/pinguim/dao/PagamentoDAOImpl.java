package br.unesp.rc.pinguim.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.Pagamento;


public class PagamentoDAOImpl {

	public static final String INSERT_PAGAMENTO = "INSERT INTO Pagamento (metodoPagamento) VALUES (?)";
    public PagamentoDAOImpl() {}


    /**
     * Salva o pagamento
     * @param con :  conexão
     * @param pagamento : Pagamento que será salvo
     * @return Retorna o codigo do pagamento
     * @throws SQLException
     */
    public long salvar(Connection con, Pagamento pagamento) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet res = null;
        long idPagamento = -1;

        if (con != null) {
            pstm = con.prepareStatement(INSERT_PAGAMENTO, PreparedStatement.RETURN_GENERATED_KEYS);

            pstm.setString(1, pagamento.getMetodoPagamento());
            
            pstm.executeUpdate();
            res = pstm.getGeneratedKeys();
            while (res.next()) {
                idPagamento = res.getLong(1);
            }
        }
        return idPagamento;
    }

    //TODO: ver se precisa do metodo busca 
    /**
     * Retorna uma Pagamento pelo seu código.
     *
     * @param codigo código da Pagamento
     * @return Pagamento cujo código foi dado, ou <code>null</code> se não encontrado.
     */
    //@Override
//    public Pagamento buscarPorCodigo(long codigo) {
//        Pagamento pagamento = null;
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet res = null;
//        boolean b = false;
//        con = FabricaConexao.getConexao();
//        
//        if (con != null) {
//            try {
//                pstm = con.prepareStatement(SELECT_PAGAMENTO);
//                res = pstm.executeQuery();
//
//                if (res.next()) {
//
//                    pagamento = new Pagamento();
//
//                    pagamento.setCodigo(pstm.getLong(1));
//                    pagamento.setMetodoPagamento(pstm.getString(2));
//
//                }
//            } catch (SQLException ex) {
//                System.out.println("Message: " + ex.getMessage());
//            }
//        }
//        
//        return b;
//    }

}
