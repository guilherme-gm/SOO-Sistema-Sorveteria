package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ServiceFactory;

public class BuscarFuncionarioPorUsuario implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		String usuario = request.getParameter("usuario");
		FuncionarioService fs = ServiceFactory.getFuncionarioService();
		
		Funcionario funcionario = fs.buscar(usuario);
		return null;
	}

	
}
