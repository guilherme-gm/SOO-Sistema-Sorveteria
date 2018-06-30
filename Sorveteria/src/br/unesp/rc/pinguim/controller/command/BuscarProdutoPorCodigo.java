package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

public class BuscarProdutoPorCodigo implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		Produto produto = new Produto();
		long codigo =Long.parseLong(request.getParameter("codigo"));
		
		ProdutoService ps = ServiceFactory.getProdutoService();
		Produto prod = ps.buscar(codigo);
		
		return null;
		
	}

}
