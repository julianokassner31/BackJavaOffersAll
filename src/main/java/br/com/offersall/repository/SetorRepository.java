package br.com.offersall.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.offersall.pojo.Empresa;
import br.com.offersall.pojo.Setor;

public interface SetorRepository extends JpaRepository<Setor, Serializable>{

	public List<Setor> findSetorByEmpresa(Empresa empresa);
}
