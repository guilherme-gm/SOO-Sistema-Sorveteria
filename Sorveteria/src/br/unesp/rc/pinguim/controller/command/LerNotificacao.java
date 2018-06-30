package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.service.NotificacaoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

@Command(url = "/LerNotificacao")
public class LerNotificacao implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
		long id = Long.parseLong(request.getParameter("idNotificacao").toString());
		
		NotificacaoService ns = ServiceFactory.getNotificacaoService();
		
		// TODO : Isso aqui deve retornar um json
		
		if (ns.ler(id)) {
			
		} else {
			
		}
		
		return new CommandResult("home.jsp");
	}

}
