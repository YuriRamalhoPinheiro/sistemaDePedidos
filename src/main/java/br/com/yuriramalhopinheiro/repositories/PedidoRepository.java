package br.com.yuriramalhopinheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuriramalhopinheiro.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
