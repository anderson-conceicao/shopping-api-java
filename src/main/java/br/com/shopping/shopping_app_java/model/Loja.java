package br.com.shopping.shopping_app_java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity

public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@Column(name = "cnpj")
	@NotNull
	private String cnpj;

	@Column(name = "piso")
	@NotNull
	private String piso;

	@Column(name = "numero")
	@NotNull
	private String numero;

	@Column(name = "situacao")
	@NotNull
	private String tipoSituacao;

	@Override
	public String toString() {
		return "Loja [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", piso=" + piso + ", numero=" + numero
				+ ", tipoSituacao=" + tipoSituacao + ", segmentos=" + segmentos + "]";
	}

	@ManyToMany
	@JoinTable(name = "loja_segmento", joinColumns = @JoinColumn(name = "loja_id"), inverseJoinColumns = @JoinColumn(name = "segmento_id"))
	private List<Segmento> segmentos = new ArrayList<Segmento>();

	public List<Segmento> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<Segmento> segmentos) {
		this.segmentos = segmentos;
	}

	public Loja() {
		super();
	}

	@JsonCreator
	public Loja(Long id, @JsonProperty(value = "nome")String nome,  @JsonProperty(value = "cnpj")String cnpj, String piso, String numero, String tipoSituacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.piso = piso;
		this.numero = numero;
		this.tipoSituacao = tipoSituacao;

	}

	public String getTipoSituacao() {
		return tipoSituacao;
	}

	public void setTipoSituacao(String tipoSituacao) {
		this.tipoSituacao = tipoSituacao;
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

	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
