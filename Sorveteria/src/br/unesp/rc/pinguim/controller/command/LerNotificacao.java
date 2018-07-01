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
		CommandResult cr = new CommandResult();
		cr.setJson(true);
		request.setAttribute("json", ns.ler(id));

		return cr;
	}

}
