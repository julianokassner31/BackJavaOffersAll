package br.com.offersall.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.offersall.pojo.Empresa;
import br.com.offersall.pojo.ProdutoEmpresa;

public class teste {

	public static void main(String[] args) throws JsonProcessingException {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<ProdutoEmpresa, ProdutoEmpresaDTO>() {

			@Override
			protected void configure() {
				String criptId = source.criptId();
				map().setId(criptId);
			}
		});
		
		ProdutoEmpresa p = new ProdutoEmpresa();
		p.setId(1);
		Empresa empresa = new Empresa();
		empresa.setCnpj("00000000");
		empresa.setNome("fantasia");
		p.setEmpresa(empresa);
		
		ProdutoEmpresaDTO map = modelMapper.map(p, ProdutoEmpresaDTO.class );
		
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(map);
		
		System.out.println(writeValueAsString);
	}

}
