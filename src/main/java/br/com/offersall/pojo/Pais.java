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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name = "pais", schema = "requisicao")
public class Pais extends PojoUtils implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private boolean ativo;
	private Set<Estado> estados = new HashSet<Estado>(0);
	
	public Pais(){}
	
	@Id
	@SequenceGenerator(name="generator", sequenceName="requisicao.pais_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@NotNull
	@Size(min=3, max=25)
//	@UniquePais
	@Column(name = "nm_pais", nullable = false, unique=true)
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
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pais")
	@JsonManagedReference(value="pais-estado")
	public Set<Estado> getEstados() {
		return estados;
	}

	public void setEstados(Set<Estado> estados) {
		this.estados = estados;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

}
