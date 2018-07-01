package br.unesp.rc.pinguim.models;


import java.util.Date;
import java.util.List;


/**
 * Define um Venda
 */
public class Venda {

    private long codigo;
    private Double total;
    private Date dataVenda;
    private Funcionario vendedor;
    private List<ItemVenda> itens;
    private Pagamento pagamento;

    /**
     * Define o valor de codigo
     * @param codigo : codigo da Venda
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo da Venda
     * @return Retorna o valor de codigo
     */
    public long getCodigo() {
        return this.codigo;
    } 
    
    /**
     * Define o valor de total
     * @param total : total da Venda
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Retorna o valor de total da Venda
     * @return Retorna o valor de total
     */
    public Double getTotal() {
        return this.total;
    } 
    
    /**
     * Define o valor de dataVenda
     * @param dataVenda : dataVenda da Venda
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * Retorna o valor de dataVenda da Venda
     * @return Retorna o valor de dataVenda
     */
    public Date getDataVenda() {
        return this.dataVenda;
    } 
    
    /**
     * Define o valor de vendedor
     * @param vendedor : vendedor da Venda
     */
    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Retorna o valor de vendedor da Venda
     * @return Retorna o valor de vendedor
     */
    public Funcionario getVendedor() {
        return this.vendedor;
    }

    /**
     * Retorna os itens da Venda
     * @return Retorna os itens da Venda
     */
	public List<ItemVenda> getItens() {
		return itens;
	}
	
	/**
	 * Define os itens da Venda
	 * @param itens : itens da Venda
	 */
	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	/**
	 * Retorna o pagamento da Venda
	 * @return Retorna o pagemento
	 */
	public Pagamento getPagamento() {
		return pagamento;
	}

	/**
	 * Define o pagamento da Venda
	 * @param pagamento : pagemento da venda 
	 */
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	} 
    
	
    
}

