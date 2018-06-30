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
    
    // ============
    // Gui

    
    // ============
    // Ju

}
