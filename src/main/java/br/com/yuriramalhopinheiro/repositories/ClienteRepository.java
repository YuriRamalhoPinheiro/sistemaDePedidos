package br.com.yuriramalhopinheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuriramalhopinheiro.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
