package br.unesp.rc.pinguim.service;

public class ServiceFactory {
	
    private ServiceFactory() {}
    
    // ============
    // Jheni
    
    
    // ============
    // Gui
    public static NotificacaoService getNotificacaoService() {
    	return new NotificacaoServiceImpl();
    }

    
    // ============
    // Ju


}
