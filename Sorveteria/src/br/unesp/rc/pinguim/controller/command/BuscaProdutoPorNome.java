package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

public class BuscaProdutoPorNome implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");
		ProdutoService ps = ServiceFactory.getProdutoService();
		
		Produto produto = ps.buscar(nome);
		return null;
	}

	
}
