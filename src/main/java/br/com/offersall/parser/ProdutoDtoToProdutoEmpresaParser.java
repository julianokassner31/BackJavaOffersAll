package br.com.offersall.parser;

import br.com.offersall.dto.ProdutoEmpresaDTO;
import br.com.offersall.pojo.ProdutoEmpresa;

public class ProdutoDtoToProdutoEmpresaParser {

	ProdutoEmpresa produtoEmpresa = new ProdutoEmpresa();
	ProdutoEmpresaDTO produtoEmpresaDTO;
	
	public ProdutoDtoToProdutoEmpresaParser(ProdutoEmpresaDTO produtoEmpresaDTO) {
		this.produtoEmpresaDTO = produtoEmpresaDTO;
	}
	
	public void parser() {
		produtoEmpresa.setAtivo(produtoEmpresaDto.getAtivo());
		produtoEmpresa.setEmpresa(empresa);
		produtoEmpresa.setPreco(preco);
		produtoEmpresa.setPrecoPromocional(precoPromocional);
		produtoEmpresa.setProduto(produto);
		produtoEmpresa.setPromocao(promocao);
		produtoEmpresa.setQuantidadeUnidadeMedida(quantidadeUnidadeMedida);
		produtoEmpresa.setSetor(setor);
		produtoEmpresa.setUnidadeMedida(unidadeMedida);
		produtoEmpresa.setUsuario(usuario);
	}
	
}
