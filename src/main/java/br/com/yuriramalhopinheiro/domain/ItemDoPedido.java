package br.com.yuriramalhopinheiro.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="item_do_pedido")
public class ItemDoPedido implements Serializable {

	private static final long serialVersionUID = 1l;

	@EmbeddedId	
	private ItemDoPedidoPK id = new ItemDoPedidoPK();

	private Double desconto;
	private Integer quantidade;
	private Double preco;

	public ItemDoPedido() {
	}

	public ItemDoPedido(Produto produto, Pedido pedido, Double desconto, Integer quantidade, Double preco) {
		super();
		this.id.setProduto(produto);
		this.id.setPedido(pedido);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return this.id.getPedido();
	}
	
	public Produto getProduto() {
		return this.id.getProduto();
	}
	
	public ItemDoPedidoPK getItemDoPedidoPK() {
		return id;
	}

	public void setItemDoPedidoPK(ItemDoPedidoPK itemDoPedidoPK) {
		this.id = itemDoPedidoPK;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
