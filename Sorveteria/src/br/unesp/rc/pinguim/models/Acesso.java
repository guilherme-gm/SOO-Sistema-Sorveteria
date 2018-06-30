package br.unesp.rc.pinguim.models;


/**
 * Define um Acesso
 */
public class Acesso {

    private String usuario;
    private String senha;

    /**
     * Define o valor de usuario
     * @param usuario : usuario da Acesso
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna o valor de usuario da Acesso
     * @return Retorna o valor de usuario
     */
    public String getUsuario() {
        return this.usuario;
    } 
    
    /**
     * Define o valor de senha
     * @param senha : senha da Acesso
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Retorna o valor de senha da Acesso
     * @return Retorna o valor de senha
     */
    public String getSenha() {
        return this.senha;
    } 
    
}

