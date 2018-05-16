package br.com.yuriramalhopinheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yuriramalhopinheiro.domain.ItemDoPedido;
import br.com.yuriramalhopinheiro.domain.ItemDoPedidoPK;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, ItemDoPedidoPK>{
	
	
}
