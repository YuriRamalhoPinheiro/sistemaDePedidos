package br.com.yuriramalhopinheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuriramalhopinheiro.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
