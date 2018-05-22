package br.com.offersall.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.offersall.dto.ProdutoEmpresaDTO;
import br.com.offersall.model.ProdutoEmpresaModel;

@RestController
@RequestMapping("/employer/product")
public class ProdutoDaEmpresaResource {

	@Autowired
	ProdutoEmpresaModel produtoDoClienteModel;

	@GetMapping(path="/{id}",produces = "application/json")
	public ResponseEntity<ProdutoEmpresaDTO> findByIdClientAndIdProduct(@PathVariable("id") int idproduto, @RequestHeader int idempresa) throws IOException {
		ProdutoEmpresaDTO produtoEmpresa = produtoDoClienteModel.findByIdClientAndIdProduct(idproduto, idempresa);
		
		if(produtoEmpresa == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(produtoEmpresa);
	}
	
	@PostMapping(value="/register", consumes="application/json")
	public ResponseEntity<ProdutoEmpresaDTO> register(@RequestBody ProdutoEmpresaDTO p) {
		ProdutoEmpresaDTO produtoEmpresa = produtoDoClienteModel.save(p);
		return ResponseEntity.ok(produtoEmpresa);
	}
}