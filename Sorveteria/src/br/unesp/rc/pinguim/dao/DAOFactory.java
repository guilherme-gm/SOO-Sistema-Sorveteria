package br.unesp.rc.pinguim.dao;

public class DAOFactory {
	
	private DAOFactory() {}
	
    // ============
    // Jheni
	/**
     * Cria e retorna uma ProdutoDAO
     */
    public static ProdutoDAO getProdutoDAO() {
        return new ProdutoDAOImpl();
    }
    
    /**
     * Cria e retorna uma VendaDAO
     */
    public static VendaDAO getVendaDAO() {
        return new VendaDAOImpl();
    }
    // ============
    // Gui
	public static NotificacaoDAO getNotificacaoDAO() {
		return new NotificacaoDAOImpl();
	}

    
    // ============
    // Ju
    /**
     * Cria e retorna um FuncionarioDAO
     */
    public static FuncionarioDAO getFuncionarioDAO()  {
        return new FuncionarioDAOImpl();
    }

}
