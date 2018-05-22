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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.offersall.repository.CriptUtil;

@Entity
@Table(name = "usuario", schema = "requisicao")
public class Usuario extends PojoUtils implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String login;
	private String senha;
	private String ultima_senha;
	private int qtda_acesso;
	private boolean ativo;
	private boolean bloqueado;
	private Funcionario funcionario;
	private List<Permissao> permissoes = new ArrayList<>();
	private String email;
	private List<Produto> produtos = new ArrayList<>();
	private List<Promocao> promocoes = new ArrayList<>();
	private List<Setor> setores = new ArrayList<>();
	private List<ProdutoEmpresa> produtosEmpresa = new ArrayList<>();

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "nm_usuario", unique=true)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "senha")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "ultima_senha")
	public String getUltima_senha() {
		return ultima_senha;
	}

	public void setUltima_senha(String ultima_senha) {
		this.ultima_senha = ultima_senha;
	}

	@Column(name = "qtda_acesso")
	public int getQtda_acesso() {
		return qtda_acesso;
	}

	public void setQtda_acesso(int qtda_acesso) {
		this.qtda_acesso = qtda_acesso;
	}

	@Column(name = "ic_ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "ic_bloqueado")
	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id")
	@JsonBackReference(value="funcionario-usuario")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "permissoes_usuarios", schema= "requisicao",
            joinColumns = {@JoinColumn(name = "id_usuario", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_permissao", referencedColumnName = "id")})
	@JsonIgnore
	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="usuarioCadastrou")
	@JsonManagedReference(value="usuario-produto")
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="usuario")
	@JsonManagedReference(value="usuario-promocao")
	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="usuario")
	@JsonManagedReference(value="usuario-setor")
	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="usuario")
	@JsonManagedReference(value="usuario-produtoEmpresa")
	public List<ProdutoEmpresa> getProdutosEmpresa() {
		return produtosEmpresa;
	}

	public void setProdutosEmpresa(List<ProdutoEmpresa> produtosEmpresa) {
		this.produtosEmpresa = produtosEmpresa;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

}
