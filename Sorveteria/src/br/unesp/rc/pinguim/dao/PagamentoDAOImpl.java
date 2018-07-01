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
}

    