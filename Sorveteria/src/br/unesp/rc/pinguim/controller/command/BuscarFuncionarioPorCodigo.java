package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ServiceFactory;


public class BuscarFuncionarioPorCodigo implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
		long codigo =Long.parseLong(request.getParameter("codigo"));
		
		FuncionarioService fs = ServiceFactory.getFuncionarioService();
		Funcionario funcionario = fs.buscar(codigo);
        
        //TODO: check rest of the path 
		return null;
		
	}

}
