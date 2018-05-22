package br.com.offersall.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import br.com.offersall.dto.ProdutoDTO;
import br.com.offersall.pojo.Produto;

public class ProdutoMapper extends ModelMapper{
	
	public ProdutoMapper(){
		
		addMappings(new PropertyMap<Produto, ProdutoDTO>() {
			@Override
			protected void configure() {
				String criptId = source.criptId();
				map().setId(criptId);
				
				String usuario = source.getUsuarioCadastrou().criptId();
				map().setUsuarioCadastrou(usuario);
			}
		});
	}
}
