package br.com.offersall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
@Table(name = "produto_empresa", schema = "requisicao")
public class ProdutoEmpresa extends PojoUtils implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private BigDecimal preco;
	private BigDecimal precoPromocional;
	private Promocao promocao;
	private boolean ativo;
	private Setor setor;
	private Empresa empresa;
	private Usuario usuario;
	private EnumUnidadeMedida unidadeMedida;
	private double quantidadeUnidadeMedida;
	private Produto produto;
	
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "requisicao.produto_empresa_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="vl_preco", nullable = false)
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	@Column(name="vl_preco_promocional", nullable = true)
	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(BigDecimal precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	@ManyToOne
	@JoinColumn(name="id_promocao", referencedColumnName="id")
	@JsonBackReference(value="promocao-produtoEmpresa")
	public Promocao getPromocao() {
		return promocao;
	}

	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	
	@Column(name="ic_ativo")
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	@ManyToOne
	@JoinColumn(name="id_setor", referencedColumnName="id")
	@JsonBackReference(value="setor-produtoEmpresa")
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@ManyToOne
    @JoinColumn(name = "id_empresa", referencedColumnName="id")
	@JsonBackReference(value="empresa-produtoEmpresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	@Transient
	protected int comparaPrecoNormalComPromocao(BigDecimal valorNormal, BigDecimal valorNaPromocao){
		return valorNormal.compareTo(valorNaPromocao);
		
	}
	
	@Transient
	public boolean isProdutoNaPromocao() {
		return this.isAtivo() && existePromocao() && comparaPrecoNormalComPromocao(getPreco(), getPrecoPromocional()) == 1;
	}
	
	@Transient
	public boolean existePromocao(){
		return this.promocao != null && promocao.getListaProdutosEmpresa().contains(this);
	}
	
	@ManyToOne
	@JoinColumn(name="id_produto", referencedColumnName="id")
	@JsonBackReference(value="produto-produtoEmpresa")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_cadastrou", referencedColumnName="id")
	@JsonBackReference(value="usuario-produtoEmpresa")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="id_unidade_medida")
	public EnumUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(EnumUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	@Column(name="qtd_unidade_medida")
	public double getQuantidadeUnidadeMedida() {
		return this.quantidadeUnidadeMedida;
	}
	
	public void setQuantidadeUnidadeMedida(double quantidadeUnidadeMedida) {
		this.quantidadeUnidadeMedida = quantidadeUnidadeMedida;
	}
	
	@Override
	@Transient
	public String criptId() {
		return CriptUtil.encrypt(this.id);
	}

}
