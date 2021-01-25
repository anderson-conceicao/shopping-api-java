package br.com.shopping.shopping_app_java.model.enums;

public enum TipoSituacao {
	
	ATIVA(1,"Ativa"), INATIVA(2,"Inativa");
	
	private int codigo;
	private String descricao;

	private TipoSituacao(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;

	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoSituacao toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}

		for (TipoSituacao x : TipoSituacao.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + codigo);

	}

}
