package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

public class BuscarProdutoPorCodigo implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
		long codigo =Long.parseLong(request.getParameter("codigo"));
		
		ProdutoService ps = ServiceFactory.getProdutoService();
		@SuppressWarnings("unused")
		Produto produto = ps.buscar(codigo);
		//TO DO: ver para onde vai
		return null;
		
	}

}
