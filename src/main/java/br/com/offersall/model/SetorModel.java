package br.com.offersall.model;

import java.util.List;

import br.com.offersall.dto.SetorDTO;
import br.com.offersall.pojo.Setor;

public interface SetorModel {

	public List<Setor> findSetorByEmpresa(Integer idempresa);
	public SetorDTO saveOrUpdate(SetorDTO setorDTO, Integer idemmpresa);
}
