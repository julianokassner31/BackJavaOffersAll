package br.com.offersall.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.offersall.pojo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Serializable>{

	@Query(value="SELECT * FROM requisicao.produto p where p.no_codigo_barras = :ean ", nativeQuery=true)
	public Produto findProductPreRegistred(@Param("ean") Long ean);
}
