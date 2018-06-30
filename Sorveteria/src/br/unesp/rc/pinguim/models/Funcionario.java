package br.unesp.rc.pinguim.models;


import java.util.Date;


/**
 * Define um Funcionario
 */
public class Funcionario {

    private long codigo;
    private String nome;
    private Endereco endereco;
    private Contato contato;
    private String cpf;
    private Date dataNascimento;
    private Cargo cargo;

    /**
     * Define o valor de codigo
     * @param codigo : codigo da Funcionario
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo da Funcionario
     * @return Retorna o valor de codigo
     */
    public long getCodigo() {
        return this.codigo;
    } 
    
    /**
     * Define o valor de nome
     * @param nome : nome da Funcionario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor de nome da Funcionario
     * @return Retorna o valor de nome
     */
    public String getNome() {
        return this.nome;
    } 
    
    /**
     * Define o valor de endereco
     * @param endereco : endereco da Funcionario
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o valor de endereco da Funcionario
     * @return Retorna o valor de endereco
     */
    public Endereco getEndereco() {
        return this.endereco;
    } 
    
    /**
     * Define o valor de contato
     * @param contato : contato da Funcionario
     */
    public void setContato(Contato contato) {
        this.contato = contato;
    }

    /**
     * Retorna o valor de contato da Funcionario
     * @return Retorna o valor de contato
     */
    public Contato getContato() {
        return this.contato;
    } 
    
    /**
     * Define o valor de cpf
     * @param cpf : cpf da Funcionario
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o valor de cpf da Funcionario
     * @return Retorna o valor de cpf
     */
    public String getCpf() {
        return this.cpf;
    } 
    
    /**
     * Define o valor de dataNascimento
     * @param dataNascimento : dataNascimento da Funcionario
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna o valor de dataNascimento da Funcionario
     * @return Retorna o valor de dataNascimento
     */
    public Date getDataNascimento() {
        return this.dataNascimento;
    } 
    
    /**
     * Define o valor de cargo
     * @param cargo : cargo da Funcionario
     */
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /**
     * Retorna o valor de cargo da Funcionario
     * @return Retorna o valor de cargo
     */
    public Cargo getCargo() {
        return this.cargo;
    } 
    
}

