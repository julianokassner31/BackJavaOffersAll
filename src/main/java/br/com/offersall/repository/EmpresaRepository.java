package br.com.offersall.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.offersall.pojo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Serializable>{

}
