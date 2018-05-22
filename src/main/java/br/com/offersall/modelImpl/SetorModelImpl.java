package br.com.offersall.modelImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.offersall.dto.SetorDTO;
import br.com.offersall.model.SetorModel;
import br.com.offersall.pojo.Empresa;
import br.com.offersall.pojo.Setor;
import br.com.offersall.repository.EmpresaRepository;
import br.com.offersall.repository.SetorRepository;

@Service
public class SetorModelImpl implements SetorModel{

	@Autowired
	SetorRepository setorRepository;
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Setor> findSetorByEmpresa(Integer idempresa) {
		Empresa empresa = empresaRepository.getOne(idempresa);
		return setorRepository.findSetorByEmpresa(empresa);
	}

	@Override
	public SetorDTO saveOrUpdate(SetorDTO setorDTO, Integer idemmpresa) {
		Empresa empresa = empresaRepository.getOne(idemmpresa);
		Setor setor = modelMapper.map(setorDTO, Setor.class);
		setor.setEmpresa(empresa);
		Setor save = setorRepository.saveAndFlush(setor);
		return modelMapper.map(save, SetorDTO.class);
	}

}
