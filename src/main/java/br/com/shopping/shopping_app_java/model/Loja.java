package br.com.shopping.shopping_app_java.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity(name="loja")
@Table(name="loja")
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



	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "loja_segmento", joinColumns = @JoinColumn(name = "loja_id"), inverseJoinColumns = @JoinColumn(name = "segmento_id"))
	private List<Segmento> segmentos;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Situacao situacao;


	public Loja() {
		super();
	}

	@JsonCreator
	public Loja(Long id, @JsonProperty(value = "nome")String nome,  @JsonProperty(value = "cnpj")String cnpj, String piso, String numero, Situacao situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.piso = piso;
		this.numero = numero;
		this.situacao = situacao;

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

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Segmento> getSegmentos() {
		return segmentos;
	}

	public void setSegmentos(List<Segmento> segmentos) {
		this.segmentos = segmentos;
	}

}
