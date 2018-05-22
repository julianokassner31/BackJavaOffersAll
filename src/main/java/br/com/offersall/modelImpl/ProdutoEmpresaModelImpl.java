package br.com.offersall.modelImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.offersall.dto.ProdutoEmpresaDTO;
import br.com.offersall.model.ProdutoEmpresaModel;
import br.com.offersall.pojo.ProdutoEmpresa;
import br.com.offersall.repository.EmpresaRepository;
import br.com.offersall.repository.ProdutoEmpresaRepository;
import br.com.offersall.repository.ProdutoRepository;
import br.com.offersall.repository.SetorRepository;

@Service
public class ProdutoEmpresaModelImpl implements ProdutoEmpresaModel{

	@Autowired
	ProdutoEmpresaRepository produtoEmpresaRepository;
	
	@Autowired
	SetorRepository setorRepository;
	
	@Autowired
	EmpresaRepository empresaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public ProdutoEmpresaDTO findByIdClientAndIdProduct(Integer id, int idempresa) {
		
		try {
			ProdutoEmpresa produtoEmpresa = produtoEmpresaRepository.findByIdProdutoAndIdEmpresa(id, idempresa);
			
			return modelMapper.map(produtoEmpresa, ProdutoEmpresaDTO.class );
		
		}catch(IllegalArgumentException e) {
			return null;
		}	
	}

	@Override
	public ProdutoEmpresaDTO save(ProdutoEmpresaDTO dto) {
		ProdutoEmpresa produtoEmpresa = produtoEmpresaRepository.saveAndFlush(modelMapper.map(dto, ProdutoEmpresa.class ));
		return modelMapper.map(produtoEmpresa, ProdutoEmpresaDTO.class);
	}
}
