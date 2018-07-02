package br.unesp.rc.pinguim.dao;

/**
 * Fábrica de classes DAO
 */
public class DAOFactory {

	private DAOFactory() {
	}

	/**
	 * Cria e retorna uma ProdutoDAO
	 * 
	 * @return ProdutoDAO
	 */
	public static ProdutoDAO getProdutoDAO() {
		return new ProdutoDAOImpl();
	}

	/**
	 * Cria e retorna uma VendaDAO
	 * 
	 * @return VendaDAO
	 */
	public static VendaDAO getVendaDAO() {
		return new VendaDAOImpl();
	}

	/**
	 * Cria e retorna uma NotificacaoDAO
	 * 
	 * @return NotificacaoDAO
	 */
	public static NotificacaoDAO getNotificacaoDAO() {
		return new NotificacaoDAOImpl();
	}

	/**
	 * Cria e retorna um FuncionarioDAO
	 * 
	 * @return FuncionarioDAO
	 */
	public static FuncionarioDAO getFuncionarioDAO() {
		return new FuncionarioDAOImpl();
	}

}
