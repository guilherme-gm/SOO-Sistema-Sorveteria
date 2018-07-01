package br.unesp.rc.pinguim.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.Venda;


public interface VendaDAO {

    public static final String INSERT_VENDA = "INSERT INTO Venda (total,dataVenda,Funcionario_codigo,Pagamento_codigo) VALUES (?,?,?,?)";
    
    public boolean salvar(Venda venda);
    public Venda buscarPorCodigo(long codigo);
}
