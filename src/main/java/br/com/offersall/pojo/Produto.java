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
@Table(name="produto", schema="requisicao")
public class Produto extends PojoUtils implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Long codigoBarras;
	private String nome;
	private Usuario usuarioCadastrou;
	private List<ProdutoEmpresa> produtosEmpresa = new ArrayList<>();
	private String urlImagem;
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.produto_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	@JsonIgnore
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="no_codigo_barras", nullable = false)
	public Long getCodigoBarras() {
		return codigoBarras;
	}
	
	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
	@Column(name="nm_produto", nullable = false)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_cadastrou", referencedColumnName="id")
	@JsonBackReference(value="usuario-produto")
	public Usuario getUsuarioCadastrou() {
		return usuarioCadastrou;
	}

	public void setUsuarioCadastrou(Usuario usuario) {
		this.usuarioCadastrou = usuario;
	}
	
	@OneToMany(mappedBy="produto", fetch=FetchType.LAZY)
	@JsonManagedReference(value="produto-produtoEmpresa")
	public List<ProdutoEmpresa> getProdutosEmpresa() {
		return produtosEmpresa;
	}

	public void setProdutosEmpresa(List<ProdutoEmpresa> produtosEmpresa) {
		this.produtosEmpresa = produtosEmpresa;
	}
	
	@Column(name="url_imagem")
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}
	
}
