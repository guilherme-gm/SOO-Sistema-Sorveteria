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
    
    /**
     * Cria um VendaService
     * @return um service
     */
    public static VendaService getVendaService() {
        return new VendaServiceImpl();
    }
    // ============
    // Gui

    
    // ============
    // Ju


}
