package br.com.offersall.resources;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.offersall.event.CriadorHeaderLocationEvent;
import br.com.offersall.pojo.Cidade;
import br.com.offersall.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	ApplicationEventPublisher publisher;
	
	@GetMapping("/findall")
	public List<Cidade> cidades(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cidade cidade(@PathVariable Integer id){
		return cidadeRepository.findOne(id);
	}
	
	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Cidade cidade, HttpServletResponse rs){
		Cidade cidadeCriada = cidadeRepository.save(cidade);
		publisher.publishEvent(new CriadorHeaderLocationEvent(this, rs, cidadeCriada.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cidadeCriada);
	}
}
