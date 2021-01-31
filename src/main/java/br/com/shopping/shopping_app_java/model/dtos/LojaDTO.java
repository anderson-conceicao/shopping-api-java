package br.com.shopping.shopping_app_java.model.dtos;


import java.io.Serializable;


import br.com.shopping.shopping_app_java.model.Loja;

public class LojaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;


	private String nome;

	public LojaDTO() {

	}

	public LojaDTO(Loja obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
