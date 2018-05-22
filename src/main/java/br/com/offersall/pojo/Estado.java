package br.com.offersall.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name = "estado", schema = "requisicao")
public class Estado extends PojoUtils implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Pais pais;
	private String nome;
	private boolean ativo;
	private Set<Cidade> cidades = new HashSet<Cidade>(0);
	
	
	@Id
	@SequenceGenerator(name="generator", sequenceName="requisicao.estado_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais", nullable = false)
	@JsonBackReference(value="pais-estado")
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	@Column(name = "nm_estado", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "ic_ativo", nullable = false)
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "estado")
	@JsonManagedReference(value="estado-cidade")
	public Set<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}
	
}
