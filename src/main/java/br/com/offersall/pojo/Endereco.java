package br.com.offersall.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name = "endereco", schema = "requisicao")
public class Endereco extends PojoUtils implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String rua;
	private Bairro bairro;
	private int numero;
	private int cep;
	private Cidade cidade;
	private boolean ativo;
	private String complemento;
	private Empresa empresa;
	private Funcionario funcionario;
	
	@Id
	@SequenceGenerator(name="generator", sequenceName="requisicao.endereco_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "nm_rua", nullable = false)
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@ManyToOne
	@JoinColumn(name="id_bairro", referencedColumnName="id")
	@JsonBackReference(value="bairro-endereco")
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	@Column(name = "no_endereco", nullable = false)
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Column(name = "no_cep", nullable = false)
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_cidade", referencedColumnName="id")
	@JsonBackReference(value="cidade-endereco")
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@Column(name = "ic_ativo")
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@Column(name = "ds_complemento")
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", referencedColumnName="id")
	@JsonBackReference(value="empresa-endereco")
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName="id")
	@JsonBackReference(value="funcionario-endereco")
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

}
