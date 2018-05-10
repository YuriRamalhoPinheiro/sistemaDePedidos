package br.com.yuriramalhopinheiro.domain.enums;

public enum EstadoDoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private Integer id;
	private String descricao;

	private EstadoDoPagamento(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static EstadoDoPagamento toEnum(Integer id) {

		if (id.equals(null)) {
			return null;
		}

		for (EstadoDoPagamento estado : EstadoDoPagamento.values()) {
			if (id.equals(estado.getId())) {
				return estado;
			}
		}

		throw new IllegalArgumentException("O id é invalido, id: " + id);
	}

	public Integer getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
