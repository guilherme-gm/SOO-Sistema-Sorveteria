package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.FuncionarioDAO;
import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Service com acoes relacionadas a um Funcionario
 */
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioDAO funcionarioDAO;

    /**
     * Inicializa o Service e cria uma instancia da DAO usada.
     */
    public FuncionarioServiceImpl() {
        this.funcionarioDAO = DAOFactory.getFuncionarioDAO();
    }

    /**
     * Salva um funcionario
     * @param funcionario : funcionario a ser salvo
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrario.
     */
    @Override
    public boolean salvar(Funcionario funcionario) {
        boolean b = false;
        
        b = this.funcionarioDAO.salvar(funcionario);
        
        return b;
    }

    /**
     * Busca um Funcionario a partir de seu codigo.
     *
     * @param codigo : codigo da Funcionario
     * @return Funcionario com o codigo correspondente ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscar(long codigo) {
        return this.funcionarioDAO.buscarPorCodigo(codigo);
    }

    /**
     * Busca um Funcionario a partir de seu usuario.
     *
     * @param usuario : usuario da Funcionario
     * @return Funcionario com o usuario correspondente ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscar(String usuario) {
        return this.funcionarioDAO.buscarPorUsuario(usuario);
    }

    /**
	 * Atualiza um determinado funcionario  
	 * @param produto : Produto que sera atualizado
	 * @return <code>true</code> se atualizou com sucesso. <code>false</code> caso contrario.
	 */
	@Override
	public boolean atualizar(Funcionario funcionario) {
		
		return this.funcionarioDAO.atualizarFuncionario(funcionario);
    }
    
    /**
     * Busca todos os funcionarios
     * @return Uma lista de funcionarios
     */
	@Override
	public List<Funcionario> buscarTodos() {
		
		return this.funcionarioDAO.buscarTodos();
	}

}
