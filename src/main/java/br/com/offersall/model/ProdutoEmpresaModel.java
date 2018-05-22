package br.com.offersall.model;

import br.com.offersall.dto.ProdutoEmpresaDTO;

public interface ProdutoEmpresaModel {

	public ProdutoEmpresaDTO findByIdClientAndIdProduct(Integer id, int idempresa);

	public ProdutoEmpresaDTO save(ProdutoEmpresaDTO dto);
	
}
