package br.unesp.rc.pinguim.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

public class BuscaProduto implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		ProdutoService ps = ServiceFactory.getProdutoService();
		
		List<Produto> produtos = ps.buscarTodos();
		return null;
	}

}
