package br.unesp.rc.pinguim.dao;

import java.util.List;

import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Interface para persist�ncia de um funcionario
 */
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

	/**
	 * Insere um novo funcion�rio
	 * 
	 * @param funcionario
	 * @return
	 */
	public boolean salvar(Funcionario funcionario);

	/**
	 * Busca um funcion�rio pelo seu c�digo
	 * 
	 * @param codigo
	 * @return
	 */
	public Funcionario buscarPorCodigo(long codigo);

	/**
	 * Busca um funcion�rio pelo seu nome de usu�rio
	 * 
	 * @param usuario
	 * @return
	 */
	public Funcionario buscarPorUsuario(String usuario);

	/**
	 * Atualiza um funcion�rio
	 * 
	 * @param funcionario
	 * @return
	 */
	public boolean atualizar(Funcionario funcionario);

	/**
	 * Retorna todos os funcion�rio
	 * 
	 * @return
	 */
	public List<Funcionario> buscarTodos();

	/**
	 * Busca um funcion�rio pelo seu usu�rio e senha
	 * 
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public Funcionario buscarPorUsuarioESenha(String usuario, String senha);
}
