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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name="contato", schema = "requisicao")
public class Contato extends PojoUtils implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private Set<Telefone> telefones = new HashSet<Telefone>(0);
	private Funcionario funcionario;
	private Empresa empresa;
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.contato_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "contato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference(value="contato-telefone")
	public Set<Telefone> getTelefones() {
		return telefones;
	}
	
	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName="id")
	@JsonBackReference(value="funcionario-contato")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", referencedColumnName="id")
	@JsonBackReference(value="empresa-contato")
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

}
