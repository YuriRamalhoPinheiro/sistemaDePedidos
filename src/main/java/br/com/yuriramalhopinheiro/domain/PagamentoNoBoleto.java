package br.com.yuriramalhopinheiro.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.yuriramalhopinheiro.domain.enums.EstadoDoPagamento;

@Entity
@Table(name="Pagamento_no_boleto")
public class PagamentoNoBoleto extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataDeVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
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
