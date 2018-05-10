package br.com.yuriramalhopinheiro.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.yuriramalhopinheiro.domain.enums.EstadoDoPagamento;

@Entity
@Table(name="Pagamento_no_boleto")
public class PagamentoNoBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private Date dataDeVencimento;
	private Date dataDePagamento;
	
	public PagamentoNoBoleto() {
	}
	
	public PagamentoNoBoleto(Integer id, EstadoDoPagamento estadoDoPagamento, Pedido pedido, Date dataPagamento, Date dataDeVencimento) {
		super(id, estadoDoPagamento, pedido);
		this.dataDePagamento = dataPagamento;
		this.dataDeVencimento = dataDeVencimento;
	}

	public Date getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setDataDeVencimento(Date dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}

	public Date getDataDePagamento() {
		return dataDePagamento;
	}

	public void setDataDePagamento(Date dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}
	
}
