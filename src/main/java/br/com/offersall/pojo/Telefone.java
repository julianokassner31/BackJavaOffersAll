package br.com.offersall.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name = "telefone", schema = "requisicao")
public class Telefone extends PojoUtils implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String numero;
	private Contato contato;
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.telefone_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "numero", nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@ManyToOne
	@JoinColumn(name="id_contato", referencedColumnName="id")
	@JsonBackReference(value="contato-telefone")
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

}
