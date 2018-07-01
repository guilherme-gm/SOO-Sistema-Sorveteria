package br.unesp.rc.pinguim.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ServiceFactory;


public class BuscarFuncionario implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		FuncionarioService fs = ServiceFactory.getFuncionarioService();
		
		// TODO : Talvez tirar?
		
		@SuppressWarnings("unused")
		List<Funcionario> produtos = fs.buscarTodos();
		return null;
	}

}
