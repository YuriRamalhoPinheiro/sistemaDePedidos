package br.com.yuriramalhopinheiro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuriramalhopinheiro.domain.Cliente;
import br.com.yuriramalhopinheiro.repositories.ClienteRepository;
import br.com.yuriramalhopinheiro.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscarPorId(Integer id) {

		Optional<Cliente> object = this.clienteRepository.findById(id);

		return object.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
