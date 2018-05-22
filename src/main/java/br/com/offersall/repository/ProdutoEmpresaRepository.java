package br.com.offersall.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.offersall.pojo.ProdutoEmpresa;

public interface ProdutoEmpresaRepository extends JpaRepository<ProdutoEmpresa, Serializable>{
	
	@Query("select p from ProdutoEmpresa p inner join p.empresa e where p.id = :idproduto and e.id = :idempresa")
	public ProdutoEmpresa findByIdProdutoAndIdEmpresa(@Param("idproduto") Integer idproduto, @Param("idempresa") Integer idempresa);

}
