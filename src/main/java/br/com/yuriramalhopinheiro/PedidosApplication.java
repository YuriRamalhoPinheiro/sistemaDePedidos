package br.com.yuriramalhopinheiro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.yuriramalhopinheiro.domain.Categoria;
import br.com.yuriramalhopinheiro.domain.Cidade;
import br.com.yuriramalhopinheiro.domain.Estado;
import br.com.yuriramalhopinheiro.domain.Produto;
import br.com.yuriramalhopinheiro.repositories.CategoriaRepository;
import br.com.yuriramalhopinheiro.repositories.CidadeRepository;
import br.com.yuriramalhopinheiro.repositories.EstadoRepository;
import br.com.yuriramalhopinheiro.repositories.ProdutoRepository;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Eletrônicos");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mause", 80.00);
		
		categoria1.setProdutos(Arrays.asList(produto1, produto2, produto3));
		categoria2.setProdutos(Arrays.asList(produto1));
		
		produto1.setCategorias(Arrays.asList(categoria1, categoria2));
		produto2.setCategorias(Arrays.asList(categoria1, categoria2));
		produto3.setCategorias(Arrays.asList(categoria1));
		
		Estado estado1 = new Estado(null, "São Paulo");
		Estado estado2 = new Estado(null, "Minas Gerais");
		
		Cidade cidade1 = new Cidade(null, "Uberlândia", estado2);
		Cidade cidade2 = new Cidade(null, "Campinas", estado1);
		Cidade cidade3 = new Cidade(null, "Ribeirão Pretos", estado1);
		
		estado1.setCidades(Arrays.asList(cidade2, cidade3));
		estado2.setCidades(Arrays.asList(cidade1));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		this.produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		this.estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		this.cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
	}
	
}
