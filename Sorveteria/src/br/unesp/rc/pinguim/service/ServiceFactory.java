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

    
    // ============
    // Ju
    /**
     * Cria um FuncionarioService
     * @return um service
     */
    public static FuncionarioService getFuncionarioService() {
        return new FuncionarioServiceImpl();
    }


}
