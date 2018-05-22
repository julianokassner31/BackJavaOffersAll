package br.com.offersall.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.offersall.dto.SetorDTO;
import br.com.offersall.model.SetorModel;

@RestController
@RequestMapping("/employer/sector")
public class SetorResource {
	
	@Autowired
	SetorModel setorModel;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<?> getSectorsByEmployer(@RequestHeader Integer idempresa){
	
		return new ResponseEntity<>(setorModel.findSetorByEmpresa(idempresa), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> register(@RequestHeader Integer idempresa, @Valid @RequestBody SetorDTO setorDTO){
		
		return new ResponseEntity<>(setorModel.saveOrUpdate(setorDTO, idempresa), HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestHeader Integer idempresa, @Valid @RequestBody SetorDTO setorDTO){
		
		return new ResponseEntity<>(setorModel.saveOrUpdate(setorDTO, idempresa), HttpStatus.OK);
		
	}

}
