package br.unesp.rc.pinguim.models;


/**
 * Define um Endereco
 */
public class Endereco {

    private String rua;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;

    /**
     * Define o valor de rua
     * @param rua : rua da Endereco
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Retorna o valor de rua da Endereco
     * @return Retorna o valor de rua
     */
    public String getRua() {
        return this.rua;
    } 
    
    /**
     * Define o valor de numero
     * @param numero : numero da Endereco
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Retorna o valor de numero da Endereco
     * @return Retorna o valor de numero
     */
    public String getNumero() {
        return this.numero;
    } 
    
    /**
     * Define o valor de cep
     * @param cep : cep da Endereco
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna o valor de cep da Endereco
     * @return Retorna o valor de cep
     */
    public String getCep() {
        return this.cep;
    } 
    
    /**
     * Define o valor de cidade
     * @param cidade : cidade da Endereco
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Retorna o valor de cidade da Endereco
     * @return Retorna o valor de cidade
     */
    public String getCidade() {
        return this.cidade;
    } 
    
    /**
     * Define o valor de estado
     * @param estado : estado da Endereco
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Retorna o valor de estado da Endereco
     * @return Retorna o valor de estado
     */
    public String getEstado() {
        return this.estado;
    } 
    
}

