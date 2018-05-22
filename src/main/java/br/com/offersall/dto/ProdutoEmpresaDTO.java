package br.com.offersall.dto;

import java.math.BigDecimal;

import br.com.offersall.pojo.EnumUnidadeMedida;
import br.com.offersall.pojo.Promocao;

public class ProdutoEmpresaDTO{																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																														
	
	private int id;
	private BigDecimal preco;
	private BigDecimal precoPromocional;
	private Promocao promocao;
	private boolean ativo;
	private EnumUnidadeMedida unidadeMedida;
	private double quantidadeUnidadeMedida;
	private ProdutoDTO produto;
	private EmpresaDTO empresa;
	private SetorDTO setor;
	private UsuarioDTO usuario;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}
	public void setPrecoPromocional(BigDecimal precoPromocional) {
		this.precoPromocional = precoPromocional;
	}
	public Promocao getPromocao() {
		return promocao;
	}
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public EnumUnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(EnumUnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	public double getQuantidadeUnidadeMedida() {
		return quantidadeUnidadeMedida;
	}
	public void setQuantidadeUnidadeMedida(double quantidadeUnidadeMedida) {
		this.quantidadeUnidadeMedida = quantidadeUnidadeMedida;
	}
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	public EmpresaDTO getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}
	public SetorDTO getSetor() {
		return setor;
	}
	public void setSetor(SetorDTO setor) {
		this.setor = setor;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}
}
