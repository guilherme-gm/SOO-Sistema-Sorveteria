package br.unesp.rc.pinguim.service;

public class ServiceFactory {
	
    private ServiceFactory() {}
    
    // ============
    // Jheni
    /**
     * Cria um ProdutoService
     * @return um service
     */
    public static ProdutoService getProdutoService() {
        return new ProdutoServiceImpl();
    }
    
    // ============
    // Gui
    public static NotificacaoService getNotificacaoService() {
    	return new NotificacaoServiceImpl();
    }

    
    // ============
    // Ju


}
