package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.FuncionarioDAO;
import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Service com acoes relacionadas a uma Funcionario
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
     * Salva uma funcionario
     * @param funcionario : funcionario a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrario.
     */
    @Override
    public boolean salvar(Funcionario funcionario) {
        boolean b = false;
        
        b = this.funcionarioDAO.salvar(funcionario);
        
        return b;
    }

    /**
     * Busca uma Funcionario a partir de seu codigo.
     *
     * @param codigo : codigo da Funcionario
     * @return a Funcionario com o codigo correspondente ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscar(long codigo) {
        return this.funcionarioDAO.buscarPorCodigo(codigo);
    }

    /**
     * Busca umm Funcionario a partir de seu codigo.
     *
     * @param usuario : usuario da Funcionario
     * @return a Funcionario com o usuario correspondente ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscar(String usuario) {
        return this.funcionarioDAO.buscarPorUsuario(usuario);
    }

}
