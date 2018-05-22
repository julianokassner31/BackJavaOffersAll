package br.com.offersall.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name="promocao", schema="requisicao")
public class Promocao extends PojoUtils implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Date inicio;
	private Date fim;
	private boolean ativo;
	private Set<ProdutoEmpresa> listaProdutosEmpresa = new HashSet<ProdutoEmpresa>(0);
	private Empresa empresa;
	private Usuario usuario;
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.promocao_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="nm_promocao", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="dt_inicio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	@Column(name="dt_fim", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	@OneToMany(mappedBy="promocao", targetEntity = ProdutoEmpresa.class, fetch=FetchType.LAZY)
	@JsonManagedReference(value="promocao-produtoEmpresa")
	public Set<ProdutoEmpresa> getListaProdutosEmpresa() {
		return listaProdutosEmpresa;
	}

	public void setListaProdutosEmpresa(Set<ProdutoEmpresa> listaProdutosEmpresa) {
		this.listaProdutosEmpresa = listaProdutosEmpresa;
	}

	@ManyToOne
	@JoinColumn(name="id_empresa", referencedColumnName="id")
	@JsonBackReference(value="empresa-promocao")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Column(name="ic_ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_cadastrou", referencedColumnName="id")
	@JsonBackReference(value="usuario-promocao")
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
