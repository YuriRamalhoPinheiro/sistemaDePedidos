package br.com.yuriramalhopinheiro;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.yuriramalhopinheiro.domain.Categoria;
import br.com.yuriramalhopinheiro.domain.Cidade;
import br.com.yuriramalhopinheiro.domain.Cliente;
import br.com.yuriramalhopinheiro.domain.Endereco;
import br.com.yuriramalhopinheiro.domain.Estado;
import br.com.yuriramalhopinheiro.domain.ItemDoPedido;
import br.com.yuriramalhopinheiro.domain.Pagamento;
import br.com.yuriramalhopinheiro.domain.PagamentoNoBoleto;
import br.com.yuriramalhopinheiro.domain.PagamentoNoCartao;
import br.com.yuriramalhopinheiro.domain.Pedido;
import br.com.yuriramalhopinheiro.domain.Produto;
import br.com.yuriramalhopinheiro.domain.enums.EstadoDoPagamento;
import br.com.yuriramalhopinheiro.domain.enums.TipoCliente;
import br.com.yuriramalhopinheiro.repositories.CategoriaRepository;
import br.com.yuriramalhopinheiro.repositories.CidadeRepository;
import br.com.yuriramalhopinheiro.repositories.ClienteRepository;
import br.com.yuriramalhopinheiro.repositories.EnderecoRepository;
import br.com.yuriramalhopinheiro.repositories.EstadoRepository;
import br.com.yuriramalhopinheiro.repositories.ItemDoPedidoRepository;
import br.com.yuriramalhopinheiro.repositories.PagamentoRepository;
import br.com.yuriramalhopinheiro.repositories.PedidoRepository;
import br.com.yuriramalhopinheiro.repositories.ProdutoRepository;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;
	
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
		Cidade cidade5 = new Cidade(null, "Araçuaí", estado2);

		estado1.setCidades(Arrays.asList(cidade2, cidade3));
		estado2.setCidades(Arrays.asList(cidade1, cidade5));
		
		Cliente cliente = new Cliente(null, "Yuri Ramalho Pinheiro", "yuri_uy@hotmail.com", "096.833.406-79",
				TipoCliente.PESSOA_FISICA);
		cliente.setTelefones("33999292281");
		cliente.setTelefones("3337313280");
		
		Endereco endereco = new Endereco(null, "Rua Santa Rita", "103", "casa", "Esplanada", "39600-000", cidade5, cliente);
		Endereco endereco2 = new Endereco(null, "Avenida Principal", "350", "Apartamento", "Centro", "39656-000", cidade2, cliente);
		
		cliente.setEnderecos(Arrays.asList(endereco, endereco2));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		Date data = simpleDateFormat.parse("20/02/2018 15:38");
		Date data2 = simpleDateFormat.parse("27/04/2018 14:35");
		Date data3 = simpleDateFormat.parse("28/04/2018 20:25");
		
		Pedido pedido1 = new Pedido(null, data, cliente, endereco);
		Pedido pedido2 = new Pedido(null, data2, cliente, endereco);
		
		Pagamento pagamentoNoCartao = new PagamentoNoCartao(null, EstadoDoPagamento.QUITADO, pedido1, 2);
		Pagamento pagamentoNoBoleto = new PagamentoNoBoleto(null, EstadoDoPagamento.QUITADO, pedido2, data2, data3);
		
		pedido1.setPagamento(pagamentoNoCartao);
		pedido2.setPagamento(pagamentoNoBoleto);
		
		ItemDoPedido item1 = new ItemDoPedido(produto1, pedido1, 200.00, 2, 1.800);
		ItemDoPedido item2 = new ItemDoPedido(produto2, pedido1, 60.00, 1, 1200.00);
		ItemDoPedido item3 = new ItemDoPedido(produto3, pedido2, 20.00, 2, 120.00);
		
		pedido1.setItens(Arrays.asList(item1, item2));
		pedido2.setItens(Arrays.asList(item3));
		
		produto1.setItens(Arrays.asList(item1));
		produto2.setItens(Arrays.asList(item2));
		produto3.setItens(Arrays.asList(item3));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		this.produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		this.estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		this.cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3, cidade5));
		this.clienteRepository.saveAll(Arrays.asList(cliente));
		this.enderecoRepository.saveAll(Arrays.asList(endereco, endereco2));
		this.pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		this.pagamentoRepository.saveAll(Arrays.asList(pagamentoNoBoleto, pagamentoNoCartao));
		this.itemDoPedidoRepository.saveAll(Arrays.asList(item1, item2, item3));
	}

}
