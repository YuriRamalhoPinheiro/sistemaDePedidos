package br.com.yuriramalhopinheiro.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.yuriramalhopinheiro.domain.enums.EstadoDoPagamento;

@Entity
@Table(name="Pagamento_no_cartao")
public class PagamentoNoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;

	public PagamentoNoCartao() {
	}

	public PagamentoNoCartao(Integer id, EstadoDoPagamento estadoDoPagamento,Pedido pedido, Integer numeroDeParcelas) {
		super(id, estadoDoPagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
