package br.com.yuriramalhopinheiro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yuriramalhopinheiro.domain.Pedido;
import br.com.yuriramalhopinheiro.repositories.PedidoRepository;
import br.com.yuriramalhopinheiro.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido buscarPorId(Integer id) {

		Optional<Pedido> findedObject = this.pedidoRepository.findById(id);

		return findedObject.orElseThrow(() -> new ObjectNotFoundException(
							"Pedido não encontrado, id: " + id + ", tipo: "+ Pedido.class.getName()));
	}

}
