package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.unesp.rc.pinguim.models.Funcionario;

public interface FuncionarioDAO {

    public static final String INSERT_FUNCIONARIO = "INSERT INTO Funcionario"
    		+ " (nome,cpf,dataNascimento,cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha) "
    		+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String SELECT_FUNCIONARIO_BY_CODIGO = "SELECT codigo,nome,cpf,dataNascimento,"
    		+ "cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha"
			+ "FROM Funcionario " + "WHERE codigo = ? ;";
    public static final String SELECT_FUNCIONARIO_BY_USUARIO = "SELECT codigo,nome,cpf,dataNascimento,"
    		+ "cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha"
			+ "FROM Funcionario " + "WHERE usuario = ? ;";
    
    
    public boolean salvar(Funcionario funcionario);
    public Funcionario buscarPorCodigo(long codigo);
	Funcionario buscarPorUsuario(String usuario);
}


