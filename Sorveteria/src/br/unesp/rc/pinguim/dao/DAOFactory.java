package br.unesp.rc.pinguim.dao;

public class DAOFactory {
	
	private DAOFactory() {}
	
    // ============
    // Jheni
    
    
    // ============
    // Gui
	public static NotificacaoDAO getNotificacaoDAO() {
		return new NotificacaoDAOImpl();
	}

    
    // ============
    // Ju

}
