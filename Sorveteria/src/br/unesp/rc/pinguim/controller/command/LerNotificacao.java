package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Command(url = "/LerNotificacao")
public class LerNotificacao implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
		long id = request.getAttribute("idNotificacao");
		
		

	}

}
