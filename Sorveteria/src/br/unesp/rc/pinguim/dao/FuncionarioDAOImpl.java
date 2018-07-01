package br.unesp.rc.pinguim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unesp.rc.pinguim.models.Acesso;
import br.unesp.rc.pinguim.models.Cargo;
import br.unesp.rc.pinguim.models.Contato;
import br.unesp.rc.pinguim.models.Endereco;
import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.utils.FabricaConexao;

public class FuncionarioDAOImpl implements FuncionarioDAO {
	
	public FuncionarioDAOImpl() {}

    /**
     * Salva um Funcionario.
     * @param funcionario 
     * @return <code>true</code> se salvou, <code>false</code> caso contrario.
     */
    @Override
    public boolean salvar(Funcionario funcionario) {
        Connection con = null;
        PreparedStatement pstm = null;
        boolean b = false;
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                con.setAutoCommit(false);
                
                pstm = con.prepareStatement(INSERT_FUNCIONARIO, PreparedStatement.RETURN_GENERATED_KEYS);

                pstm.setString(1, funcionario.getNome());
                pstm.setString(2, funcionario.getCpf());
                pstm.setDate(3, new java.sql.Date(funcionario.getDataNascimento().getTime()));
                pstm.setString(4, funcionario.getCargo().toString());
                pstm.setString(5, funcionario.getContato().getTelefone());
                pstm.setString(6, funcionario.getContato().getCelular());
                pstm.setString(7, funcionario.getContato().getEmail());
                pstm.setString(8, funcionario.getEndereco().getRua());
                pstm.setInt(9,Integer.valueOf(funcionario.getEndereco().getNumero()));
                pstm.setString(10, funcionario.getEndereco().getCep());
                pstm.setString(11, funcionario.getEndereco().getCidade());
                pstm.setString(12, funcionario.getEndereco().getEstado());
                pstm.setString(13, funcionario.getAcesso().getUsuario());
                pstm.setString(14, funcionario.getAcesso().getSenha());
                
                
                pstm.executeUpdate();
                
                con.commit();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }
        
        return b;
    }

    /**
     * Retorna um Funcionario pelo seu codigo.
     *
     * @param codigo codigo do Funcionario
     * @return Funcionario cujo codigo foi dado, ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscarPorCodigo(long codigo) {
        Funcionario funcionario = null;
        Endereco endereco = null;
        Acesso acesso = null;
        Contato contato = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_FUNCIONARIO_BY_CODIGO);
                pstm.setLong(1, codigo);
                res = pstm.executeQuery();

                if (res.next()) {

                    funcionario = new Funcionario();
                    acesso = new Acesso();
                    endereco = new Endereco();
                    contato = new Contato();
                    
                    acesso.setUsuario(res.getString("usuario"));
                    acesso.setSenha(res.getString("senha"));
                                        
                    endereco.setRua(res.getString("rua"));
                    endereco.setNumero(res.getString("numero"));
                    endereco.setCep(res.getString("cep"));
                    endereco.setCidade(res.getString("cidade"));
                    endereco.setEstado(res.getString("estado"));
                                        
                    contato.setCelular(res.getString("celular"));
                    contato.setEmail(res.getString("email"));
                    contato.setTelefone(res.getString("telefone"));
                 

                    funcionario.setCodigo(res.getLong("codigo"));
                    funcionario.setNome(res.getString("nome"));
                    funcionario.setCpf(res.getString("cpf"));
                    funcionario.setDataNascimento(res.getDate("dataNascimento"));
                    funcionario.setAcesso(acesso);
                    funcionario.setCargo(Cargo.valueOf(res.getString("cargo")));
                    funcionario.setEndereco(endereco);
                    funcionario.setContato(contato);


                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }
        
        return funcionario;
    }
    
    /**
     * Retorna um Funcionario pelo seu usuario.
     *
     * @param usuario usuario do Funcionario
     * @return Funcionario cujo usuario foi dado, ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscarPorUsuario(String usuario) {
        Funcionario funcionario = null;
        Endereco endereco = null;
        Acesso acesso = null;
        Contato contato = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_FUNCIONARIO_BY_USUARIO);
                pstm.setString(1, usuario);
                res = pstm.executeQuery();

                if (res.next()) {

                    funcionario = new Funcionario();
                    acesso = new Acesso();
                    endereco = new Endereco();
                    contato = new Contato();
                    
                    acesso.setUsuario(res.getString("usuario"));
                    acesso.setSenha(res.getString("senha"));
                                        
                    endereco.setRua(res.getString("rua"));
                    endereco.setNumero(res.getString("numero"));
                    endereco.setCep(res.getString("cep"));
                    endereco.setCidade(res.getString("cidade"));
                    endereco.setEstado(res.getString("estado"));
                                        
                    contato.setCelular(res.getString("celular"));
                    contato.setEmail(res.getString("email"));
                    contato.setTelefone(res.getString("telefone"));
                 

                    funcionario.setCodigo(res.getLong("codigo"));
                    funcionario.setNome(res.getString("nome"));
                    funcionario.setCpf(res.getString("cpf"));
                    funcionario.setDataNascimento(res.getDate("dataNascimento"));
                    funcionario.setAcesso(acesso);
                    funcionario.setCargo(Cargo.valueOf(res.getString("cargo")));
                    funcionario.setEndereco(endereco);
                    funcionario.setContato(contato);


                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }
        
        return funcionario;
    }

    /**
	 * Busca todos os funcionarios
	 * 
	 * @return Uma lista de funcionarios
	 */
	@Override
	public List<Funcionario> buscarTodos() {
        
        List<Funcionario> funcionarios = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;

		con = FabricaConexao.getConexao();

		if (con != null) {
			try {
				pstm = con.prepareStatement(SELECT_FUNCIONARIO);
				res = pstm.executeQuery();

				while (res.next()) {
					Funcionario funcionario = new Funcionario();
                    Acesso acesso = new Acesso();
                    Endereco endereco = new Endereco();
                    Contato contato = new Contato();
                    
                    acesso.setUsuario(res.getString("usuario"));
                    acesso.setSenha(res.getString("senha"));
                                        
                    endereco.setRua(res.getString("rua"));
                    endereco.setNumero(res.getString("numero"));
                    endereco.setCep(res.getString("cep"));
                    endereco.setCidade(res.getString("cidade"));
                    endereco.setEstado(res.getString("estado"));
                                        
                    contato.setCelular(res.getString("celular"));
                    contato.setEmail(res.getString("email"));
                    contato.setTelefone(res.getString("telefone"));
                 
                    funcionario.setCodigo(res.getLong("codigo"));
                    funcionario.setNome(res.getString("nome"));
                    funcionario.setCpf(res.getString("cpf"));
                    funcionario.setDataNascimento(res.getDate("dataNascimento"));
                    funcionario.setAcesso(acesso);
                    funcionario.setCargo(Cargo.valueOf(res.getString("cargo")));
                    funcionario.setEndereco(endereco);
                    funcionario.setContato(contato);

                    funcionarios.add(funcionario);
				}

			} catch (SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
		}

		return funcionarios;
    }
    /**
	 * Atualiza umm determinado funcionario 
	 * @param funcionario : Funcionario que sera ataualizado
	 * @return <code>true</code> se atualizou com sucesso. <code>false</code> caso contr�rio.
	 */
	@Override
	public boolean atualizarFuncionario (Funcionario funcionario) {
		
		Connection con = FabricaConexao.getConexao();
        PreparedStatement pstm = null;
        boolean b = false;
        
        if(con != null) {
        	try {
        		pstm = con.prepareStatement(UPDATE_FUNCIONARIO);
        		
        		pstm.setString(1, funcionario.getNome());
                pstm.setString(2, funcionario.getCpf());
                pstm.setDate(3, new java.sql.Date(funcionario.getDataNascimento().getTime()));
                pstm.setString(4, funcionario.getCargo().toString());
                pstm.setString(5, funcionario.getContato().getTelefone());
                pstm.setString(6, funcionario.getContato().getCelular());
                pstm.setString(7, funcionario.getContato().getEmail());
                pstm.setString(8, funcionario.getEndereco().getRua());
                pstm.setInt(9,Integer.valueOf(funcionario.getEndereco().getNumero()));
                pstm.setString(10, funcionario.getEndereco().getCep());
                pstm.setString(11, funcionario.getEndereco().getCidade());
                pstm.setString(12, funcionario.getEndereco().getEstado());
                pstm.setString(13, funcionario.getAcesso().getUsuario());
                pstm.setString(14, funcionario.getAcesso().getSenha());
        		pstm.executeUpdate();
        		
        		b = true;
        	}catch(SQLException ex) {
				System.out.println("Message: " + ex.getMessage());
			}
        }
		return b;
    }
    
    /**
     * Retorna um Funcionario pelo seu usuario e senha.
     *
     * @param usuario usuario do Funcionario
     * @return Funcionario cujo usuario foi dado, ou <code>null</code> se nao encontrado.
     */
    @Override
    public Funcionario buscarPorUsuarioESenha (String usuario, String senha) {
        Funcionario funcionario = null;
        Endereco endereco = null;
        Acesso acesso = null;
        Contato contato = null;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                pstm = con.prepareStatement(SELECT_FUNCIONARIO_BY_LOGIN);
                pstm.setString(1, usuario);
                pstm.setString(2, senha);
                res = pstm.executeQuery();

                if (res.next()) {

                    funcionario = new Funcionario();
                    acesso = new Acesso();
                    endereco = new Endereco();
                    contato = new Contato();
                    
                    acesso.setUsuario(res.getString("usuario"));
                    acesso.setSenha(res.getString("senha"));
                                        
                    endereco.setRua(res.getString("rua"));
                    endereco.setNumero(res.getString("numero"));
                    endereco.setCep(res.getString("cep"));
                    endereco.setCidade(res.getString("cidade"));
                    endereco.setEstado(res.getString("estado"));
                                        
                    contato.setCelular(res.getString("celular"));
                    contato.setEmail(res.getString("email"));
                    contato.setTelefone(res.getString("telefone"));
                 

                    funcionario.setCodigo(res.getLong("codigo"));
                    funcionario.setNome(res.getString("nome"));
                    funcionario.setCpf(res.getString("cpf"));
                    funcionario.setDataNascimento(res.getDate("dataNascimento"));
                    funcionario.setAcesso(acesso);
                    funcionario.setCargo(Cargo.valueOf(res.getString("cargo")));
                    funcionario.setEndereco(endereco);
                    funcionario.setContato(contato);

                }
            } catch (SQLException ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        }
        
        return funcionario;
    }

}
