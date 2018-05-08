package br.com.yuriramalhopinheiro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuriramalhopinheiro.domain.Categoria;
import br.com.yuriramalhopinheiro.repositories.CategoriaRepository;
import br.com.yuriramalhopinheiro.service.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscarPorId(Integer id) {
		
		Optional<Categoria> object = repository.findById(id);
		
		return object.orElseThrow(()-> new ObjectNotFoundException(
											"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName() ) );
	}
	
}
