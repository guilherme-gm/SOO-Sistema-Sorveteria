package br.unesp.rc.pinguim.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.reflections.Reflections;

import br.unesp.rc.pinguim.controller.command.Command;
import br.unesp.rc.pinguim.controller.command.CommandResult;
import br.unesp.rc.pinguim.controller.command.ICommand;

/**
 * Servlet implementation class SrvController
 */
@WebServlet(
		name = "SrvController",
		urlPatterns = {
				"/Cmd1",
				// Jheni
				"/InserirProduto",
				"/DoInserirProduto",
				"/BuscarProdutoPorCodigo",
				"/BuscaProdutoPorNome",
				"/BuscaProduto",
				"/AtualizarProduto",
				"/DoAtualizarProduto",
				"/Cmd2",
				// Gui
				"/LerNotificacao",
				"/ListarNotificacoes",
				
				"/Cmd3",
				// Ju
				"/InserirFuncionario",
				"/DoInserirFuncionario",
				"/BuscarFuncionarioPorCodigo",
				"/BuscarFuncionarioPorUsuario",
				"/BuscarFuncionario",
				"/AtualizarFuncionario",
				"/DoAtualizarFuncionario",
				"/Login",
				"/DoLogin"
				
		}
)
public class SrvController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Map<String, ICommand> COMMANDS;

	static {
		COMMANDS = new HashMap<>();

		Reflections reflections = new Reflections("br.unesp.rc.pinguim.controller.command");
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Command.class);

		annotated.forEach(an -> {
			Command cmd = an.getAnnotation(Command.class);
			try {
				COMMANDS.put(cmd.url(), (ICommand) an.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println("Falha ao mapear comandos");
			}
		});
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SrvController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rootPath = request.getServletContext().getContextPath();
		String command = request.getRequestURI().substring(rootPath.length());

		ICommand cmd = COMMANDS.getOrDefault(command, null);
		CommandResult result = cmd.execute(request, response);

		if (!result.isRedirect()) {
			request.setAttribute("page", result.getPage());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect(result.getPage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
