package br.unesp.rc.pinguim.service;

/**
 * Fábrica para construção de serviços
 */
public class ServiceFactory {

	private ServiceFactory() {
	}

	/**
	 * Cria um ProdutoService
	 * 
	 * @return um service
	 */
	public static ProdutoService getProdutoService() {
		return new ProdutoServiceImpl();
	}

	/**
	 * Cria um VendaService
	 * 
	 * @return um service
	 */
	public static VendaService getVendaService() {
		return new VendaServiceImpl();
	}

	/**
	 * Cria um NotificacaoService
	 * 
	 * @return um service
	 */
	public static NotificacaoService getNotificacaoService() {
		return new NotificacaoServiceImpl();
	}

	/**
	 * Cria um FuncionarioService
	 * 
	 * @return um service
	 */
	public static FuncionarioService getFuncionarioService() {
		return new FuncionarioServiceImpl();
	}

	/**
	 * Cria um LoginService
	 * 
	 * @return um service
	 */
	public static LoginService getLoginService() {
		return new LoginServiceImpl();
	}

}
