package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.FuncionarioDAO;
import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Service com acoes relacionadas ao login
 */
public class LoginServiceImpl implements LoginService {

	private FuncionarioDAO funcionarioDAO;

	/**
	 * Inicializa o Service e cria uma instancia da DAO usada.
	 */
	public LoginServiceImpl() {
		this.funcionarioDAO = DAOFactory.getFuncionarioDAO();
	}

	/**
	 * Busca um Funcionario a partir de seu login e senha.
	 *
	 * @param usuario
	 *            : usuario da Funcionario
	 * @return Funcionario com o usuario correspondente ou <code>null</code> se nao
	 *         encontrado.
	 */
	@Override
	public Funcionario buscar(String usuario, String senha) {
		return this.funcionarioDAO.buscarPorUsuarioESenha(usuario, senha);
	}

}
