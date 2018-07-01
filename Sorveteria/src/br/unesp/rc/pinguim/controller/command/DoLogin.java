package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.models.Acesso;
import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.LoginService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Realiza a verificação de login
 *
 */
@Command(url = "/DoLogin")
public class DoLogin implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
        Acesso acesso = new Acesso();
        
        acesso.setUsuario(request.getParameter("usuario"));
        acesso.setSenha(request.getParameter("senha"));
		
		LoginService fs = ServiceFactory.getLoginService();
		Funcionario funcionario = fs.buscar(acesso.getUsuario(), acesso.getSenha());
		CommandResult  rs = null;
		if(funcionario != null) {

            HttpSession session = request.getSession();
            session.setAttribute("funcionario",funcionario); 
            rs =  new CommandResult("/index.jsp", true);
		}else {
			rs = new CommandResult("/login");
		}
		return rs;
	}

	
}

