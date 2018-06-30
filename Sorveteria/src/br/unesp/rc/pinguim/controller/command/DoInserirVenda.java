package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.models.Venda;

public class DoInserirVenda implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
		Venda venda = new Venda();
		
		venda.setDataVenda(new java.util.Date());
		venda.setTotal(Double.parseDouble(request.getParameter("total")));
		Funcionario func = new Funcionario();
		func.setCodigo(1);
		venda.setVendedor(func);
		
		
		return null;
	}

	
	
}
