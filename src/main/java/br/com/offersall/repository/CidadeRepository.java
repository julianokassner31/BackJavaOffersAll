package br.com.offersall.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.offersall.pojo.Cidade;
import br.com.offersall.pojo.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Serializable>{
	
	public List<Cidade> findByEstado(Estado estado);
	public List<Cidade> findByNome(String nome);

}
