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
 * Aspecto responsável pelo controle de acesso
 */
public aspect Acesso {

	pointcut callExecuteCommand(HttpServletRequest request, HttpServletResponse response):
		call(* ICommand.execute(HttpServletRequest, HttpServletResponse)) && args(request, response);

	/**
	 * Retorna o funcionário da sessão atual
	 * 
	 * @param request
	 *            request http
	 * @return o funcionário logado
	 * @throws AccessDeniedException
	 *             Se o usuário não existir
	 */
	public Funcionario getUsuarioAtual(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null) {
			return null;
		}

		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		if (funcionario == null) {
			return null;
		}

		return funcionario;
	}

	/**
	 * Usuário não está logado e tenta acessar uma página que requer login
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 * @throws AccessDeniedException
	 *             Caso o acesso a esta página não seja permitido
	 */
	before(HttpServletRequest request, HttpServletResponse response) throws AccessDeniedException 
	: callExecuteCommand(request, response) && (!target(Login) && !target(DoLogin))
		{
		if (this.getUsuarioAtual(request) == null) {
			throw new AccessDeniedException("Login");
		}
	}

	/**
	 * Bloqueio de acesso para funcionários não-gerentes para funções de
	 * gerenciamento
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 * @throws AccessDeniedException
	 *             caso o usuário não tenha permissão.
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
			) {
		Funcionario funcionario = this.getUsuarioAtual(request);

		if (funcionario == null) {
			throw new AccessDeniedException("Login");
		}

		if (funcionario.getCargo() != Cargo.GERENTE) {
			throw new AccessDeniedException("index.jsp");
		}
	}

	/**
	 * Bloqueio de acesso para a tela de login caso o usuário já esteja logado
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 * @throws AccessDeniedException
	 *             caso o usuário não tenha permissão.
	 */
	before(HttpServletRequest request, HttpServletResponse response) throws AccessDeniedException 
	: callExecuteCommand(request, response) && 
	(
			target(Login)
			|| target(DoLogin)
			) {
		Funcionario func = this.getUsuarioAtual(request);

		if (func != null) {
			throw new AccessDeniedException("index.jsp");
		}
	}

}
