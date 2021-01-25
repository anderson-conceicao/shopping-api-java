package br.com.shopping.shopping_app_java.model;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.validation.constraints.NotNull;


import br.com.shopping.shopping_app_java.model.enums.TipoSituacao;



@Entity(name = "loja")
public class Loja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name="nome")
	@NotNull
	private String nome;
	
	@Column(name="cnpj")
	@NotNull
	private String cnpj;
	
	@Column(name="piso")
	@NotNull
	private String piso;
	
	@Column(name="numero")
	@NotNull
	private String numero;
	
	@Column(name="situacao")
	@NotNull
	private Integer tipoSituacao;
//	@OneToOne
//	@JoinColumn(name="situacao_id")
//	private Situacao situacao ;
	

		@ManyToMany(mappedBy = "lojas", targetEntity = Segmento.class)
		private List<Segmento> segmentos ;
	


	public Loja() {
		super();
	}




	public Loja(Long id, String nome, String cnpj, String piso, String numero,TipoSituacao tipoSituacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.piso = piso;
		this.numero = numero;
		this.tipoSituacao = (tipoSituacao == null) ? null : tipoSituacao.getCodigo();
		
		
	}


	public TipoSituacao getTipoSituacao() {
		return TipoSituacao.toEnum(tipoSituacao);
	}

	public void setTipoSituacao(TipoSituacao tipoSituacao) {
		this.tipoSituacao = tipoSituacao.getCodigo();
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




	public List<Segmento> getSegmentos() {
		return segmentos;
	}




	public void setSegmentos(List<Segmento> segmentos) {
		this.segmentos = segmentos;
	}




	@Override
	public String toString() {
		return "Loja [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", piso=" + piso + ", numero=" + numero
				+ ", tipoSituacao=" + tipoSituacao + ", segmentos=" + segmentos + "]";
	}






	
	

	


	

	
}
