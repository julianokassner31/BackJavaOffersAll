package br.com.offersall.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name="credencial", schema = "requisicao")
public class Credencial extends PojoUtils implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String token;
	private Empresa empresa;
	
	
	@Id
	@SequenceGenerator(name="generator", sequenceName="requisicao.credencial_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "token", nullable = false)
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa", referencedColumnName="id")
	@JsonIgnore
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
