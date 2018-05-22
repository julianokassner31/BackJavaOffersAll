package br.com.offersall.model;

import br.com.offersall.dto.ProdutoDTO;

public interface ProdutoModel {

	public ProdutoDTO findProductPreRegistred(Long ean) throws Exception;
}
