package br.com.yuriramalhopinheiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.yuriramalhopinheiro.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
