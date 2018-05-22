package br.com.offersall.modelImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.offersall.dto.ProdutoDTO;
import br.com.offersall.model.ProdutoModel;
import br.com.offersall.pojo.Produto;
import br.com.offersall.repository.ProdutoRepository;

@Service
public class ProdutoModelImpl implements ProdutoModel{

	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public ProdutoDTO findProductPreRegistred(Long ean) throws Exception{
		Produto produto = produtoRepository.findProductPreRegistred(ean);
		if(produto != null) {
			return modelMapper.map(produto, ProdutoDTO.class);
		}
		
		throw new Exception("nao encontrou recurso");
	}
}
