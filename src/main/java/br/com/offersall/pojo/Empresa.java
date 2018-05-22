package br.com.offersall.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name = "empresa", schema = "requisicao")
public class Empresa extends PojoUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String cnpj;
	private String inscricaoEstadual;
	private List<Promocao> promocoes = new ArrayList<>();
	private boolean ativo;
	private List<ProdutoEmpresa> produtosEmpresa = new ArrayList<>();
	private List<Funcionario> funcionarios = new ArrayList<>();
	private List<Setor> setores = new ArrayList<>();

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.empresa_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cnpj", nullable = false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "nm_empresa", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "no_iscricao_estadual")
	@JsonInclude(Include.NON_NULL)
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	@JsonManagedReference(value="empresa-promocao")
	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}

	@Column(name = "ic_ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	@JsonManagedReference(value="empresa-produtoEmpresa")
	public List<ProdutoEmpresa> getProdutosEmpresa() {
		return produtosEmpresa;
	}

	public void setProdutosEmpresa(List<ProdutoEmpresa> produtosEmpresa) {
		this.produtosEmpresa = produtosEmpresa;
	}
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	@JsonManagedReference(value="empresa-funcionario")
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	@JsonManagedReference(value="empresa-setor")
	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}
}
