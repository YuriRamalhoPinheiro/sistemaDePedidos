package br.com.yuriramalhopinheiro.domain.enums;

public enum TipoCliente {
	
	PESSOA_FISICA(1, "Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private Integer id;
	private String nome;
	
	private TipoCliente(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public static TipoCliente toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
		
		for(TipoCliente tipo : TipoCliente.values()) {
			if(id.equals(tipo.id)) {
				return tipo;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + id);
	}
	
}
