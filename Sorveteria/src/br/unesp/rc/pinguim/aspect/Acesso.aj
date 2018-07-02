package br.unesp.rc.pinguim.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.controller.command.AtualizarFuncionario;
import br.unesp.rc.pinguim.controller.command.AtualizarProduto;
import br.unesp.rc.pinguim.controller.command.BuscarFuncionario;
import br.unesp.rc.pinguim.controller.command.BuscarFuncionarioPorCodigo;
import br.unesp.rc.pinguim.controller.command.BuscarFuncionarioPorUsuario;
import br.unesp.rc.pinguim.controller.command.DoAtualizarFuncionario;
import br.unesp.rc.pinguim.controller.command.DoAtualizarProduto;
import br.unesp.rc.pinguim.controller.command.DoInserirFuncionario;
import br.unesp.rc.pinguim.controller.command.DoInserirProduto;
import br.unesp.rc.pinguim.controller.command.DoLogin;
import br.unesp.rc.pinguim.controller.command.ICommand;
import br.unesp.rc.pinguim.controller.command.InserirFuncionario;
import br.unesp.rc.pinguim.controller.command.InserirProduto;
import br.unesp.rc.pinguim.controller.command.LerNotificacao;
import br.unesp.rc.pinguim.controller.command.ListarFuncionarios;
import br.unesp.rc.pinguim.controller.command.ListarNotificacoes;
import br.unesp.rc.pinguim.controller.command.Login;
import br.unesp.rc.pinguim.controller.exception.AccessDeniedException;
import br.unesp.rc.pinguim.models.Cargo;
import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Aspecto respons�vel pelo controle de acesso
 */
public aspect Acesso {

	pointcut callExecuteCommand(HttpServletRequest request, HttpServletResponse response):
		call(* ICommand.execute(HttpServletRequest, HttpServletResponse)) && args(request, response);

	/**
	 * Retorna o funcion�rio da sess�o atual
	 * 
	 * @param request
	 *            request http
	 * @return o funcion�rio logado
	 */
	public Funcionario getUsuarioAtual(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (Funcionario) session.getAttribute("usuario");
	}

	/**
	 * Usu�rio n�o est� logado e tenta acessar uma p�gina que requer login
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 * @throws AccessDeniedException
	 *             Caso o acesso a esta p�gina n�o seja permitido
	 */
	before(HttpServletRequest request, HttpServletResponse response) throws AccessDeniedException 
	: callExecuteCommand(request, response) && (!target(Login) && !target(DoLogin))
		{
		System.out.println("Hello2 >>");
		HttpSession session = request.getSession();
		if (session == null) {
			throw new AccessDeniedException("Login");
		}

		Funcionario funcionario = getUsuarioAtual(request);
		if (funcionario == null) {
			throw new AccessDeniedException("Login");
		}
	}

	/**
	 * Bloqueio de acesso para funcion�rios n�o-gerentes para fun��es de
	 * gerenciamento
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 * @throws AccessDeniedException
	 *             caso o usu�rio n�o tenha permiss�o.
	 */
	before(HttpServletRequest request, HttpServletResponse response) throws AccessDeniedException 
	: callExecuteCommand(request, response) && 
	(
			target(InserirProduto) 
			|| target(DoInserirProduto)
			|| target(AtualizarProduto)
			|| target(DoAtualizarProduto)
			|| target(LerNotificacao)
			|| target(ListarNotificacoes)
			|| target(ListarFuncionarios)
			|| target(InserirFuncionario)
			|| target(DoInserirFuncionario)
			|| target(BuscarFuncionarioPorCodigo)
			|| target(BuscarFuncionarioPorUsuario)
			|| target(BuscarFuncionario)
			|| target(AtualizarFuncionario)
			|| target(DoAtualizarFuncionario)
//			|| target(Login)
//			|| target(DoLogin)
			) {
		Funcionario funcionario = getUsuarioAtual(request);
		System.out.println("Hello >>" + thisJoinPoint.getTarget().toString());
		if (funcionario.getCargo() != Cargo.GERENTE) {
			throw new AccessDeniedException("index.jsp");
		}
	}

}
