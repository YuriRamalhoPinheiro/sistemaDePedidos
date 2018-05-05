package br.com.yuriramalhopinheiro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.yuriramalhopinheiro.domain.Categoria;
import br.com.yuriramalhopinheiro.repositories.CategoriaRepository;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository repository; 
	
	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Eletrônicos");
		
		this.repository.saveAll(Arrays.asList(categoria1, categoria2));
	}
}
