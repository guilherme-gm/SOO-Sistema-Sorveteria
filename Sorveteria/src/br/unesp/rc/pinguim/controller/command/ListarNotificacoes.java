package br.unesp.rc.pinguim.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Notificacao;
import br.unesp.rc.pinguim.service.NotificacaoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Comando para listar as notificações de estoque. permite o parametro "novas"
 * (true/false) para trazer apenas as não lidas (true) ou todas (false)
 */
@Command(url = "/ListarNotificacoes")
public class ListarNotificacoes implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		boolean apenasNovas = true;

		if (request.getParameter("novas") != null) {
			apenasNovas = Boolean.parseBoolean(request.getParameter("novas"));
		}

		NotificacaoService ns = ServiceFactory.getNotificacaoService();
		List<Notificacao> notificacoes = ns.listar(10, apenasNovas);

		CommandResult rs = new CommandResult();
		request.setAttribute("json", notificacoes);
		rs.setJson(true);

		return rs;
	}

}
