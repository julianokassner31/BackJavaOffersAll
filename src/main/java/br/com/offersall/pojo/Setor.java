package br.com.offersall.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name="setor", schema = "requisicao")
public class Setor extends PojoUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Set<ProdutoEmpresa> produtosEmpresa = new HashSet<ProdutoEmpresa>();
	private Empresa empresa;
	private Usuario usuario;
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.setor_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="nm_setor", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toLowerCase();
	}
	
	@OneToMany(mappedBy="setor", fetch=FetchType.LAZY)
	@JsonManagedReference(value="setor-produtoEmpresa")
	@JsonIgnore
	public Set<ProdutoEmpresa> getProdutosEmpresa() {
		return produtosEmpresa;
	}

	public void setProdutosEmpresa(Set<ProdutoEmpresa> produtosEmpresa) {
		this.produtosEmpresa = produtosEmpresa;
	}

	@ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName="id")
	@JsonBackReference(value="empresa-setor")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@ManyToOne
    @JoinColumn(name = "id_usuario_cadastrou", referencedColumnName="id")
	@JsonBackReference(value="usuario-setor")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}
}