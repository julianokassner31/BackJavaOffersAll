package br.com.offersall.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.offersall.dto.ProdutoDTO;
import br.com.offersall.model.ProdutoModel;

@RestController
@RequestMapping("/product")
public class ProdutoResource {
	
	@Autowired
	ProdutoModel produtoModel;
	
	@Autowired
	MessageSource messageSource;

	@PostMapping(value="/find")
	public ResponseEntity<?> findByEan(@RequestBody ProdutoDTO produtoDTO){
		
		try {
			long ean = Long.parseLong(produtoDTO.getCodigoBarras());
			ProdutoDTO produto = produtoModel.findProductPreRegistred(ean);
			
			if(produto != null) {
				
				return new ResponseEntity<>(produto, HttpStatus.OK);
			}	
			
			String message = messageSource.getMessage("mensagem.recurso.nao.existe", null,LocaleContextHolder.getLocale());
			
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		
		}catch(Exception e) {
			String message = messageSource.getMessage("mensagem.recurso.nao.existe", null,LocaleContextHolder.getLocale());
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}
		
	}
}
