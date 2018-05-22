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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.offersall.repository.CriptUtil;


@Entity
@Table(name = "permissao", schema = "requisicao")
public class Permissao extends PojoUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String permissao;
	private String descricao;
    private List<Usuario> usuarios = new ArrayList<>();

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.permissao_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    @NotNull
	@Column(name = "nm_permissao", nullable = false, length = 30)
	public String getPermissao() {
		return this.permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	@Column(name = "ds_permissao", nullable = false, length = 100)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToMany(mappedBy = "permissoes", fetch = FetchType.LAZY)
	@JsonBackReference(value="usuario-permissao")
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

	
}
