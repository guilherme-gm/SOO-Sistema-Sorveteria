package br.unesp.rc.pinguim.dao;

import java.util.List;

import br.unesp.rc.pinguim.models.Funcionario;

public interface FuncionarioDAO {

	public static final String INSERT_FUNCIONARIO = "INSERT INTO Funcionario "
			+ " (nome,cpf,dataNascimento,cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_FUNCIONARIO_BY_CODIGO = "SELECT codigo,nome,cpf,dataNascimento,"
			+ "cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha " + "FROM Funcionario "
			+ "WHERE codigo = ? ;";
	public static final String SELECT_FUNCIONARIO_BY_USUARIO = "SELECT codigo,nome,cpf,dataNascimento,"
			+ "cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha " + "FROM Funcionario "
			+ "WHERE usuario = ? ;";
	public static final String UPDATE_FUNCIONARIO = "UPDATE Funcionario SET nome  = ?,  cpf  = ?,  dataNascimento  = ?,"
			+ " cargo  = ?, telefone  = ?, celular  = ?, email  = ?, rua  = ?, numero  = ?, cep  = ?, cidade  = ?, estado  = ?,"
			+ " usuario  = ?, senha  = ? WHERE  codigo  = ?;";
	public static final String SELECT_FUNCIONARIO = "SELECT codigo,nome,cpf,dataNascimento,"
			+ "cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha " + "FROM Funcionario ;";
	public static final String SELECT_FUNCIONARIO_BY_LOGIN = "SELECT codigo,nome,cpf,dataNascimento,"
			+ "cargo,telefone,celular,email,rua,numero,cep,cidade,estado,usuario,senha " + "FROM Funcionario "
			+ "WHERE usuario = ? AND senha = ? ;";

	public boolean salvar(Funcionario funcionario);

	public Funcionario buscarPorCodigo(long codigo);

	public Funcionario buscarPorUsuario(String usuario);

	public boolean atualizar(Funcionario funcionario);

	public List<Funcionario> buscarTodos();

	public Funcionario buscarPorUsuarioESenha(String usuario, String senha);
}
