package br.com.offersall.event.listner;

import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.offersall.event.CriadorHeaderLocationEvent;

@Component
public class CriadorHeaderLocationListner implements ApplicationListener<CriadorHeaderLocationEvent>{

	@Override
	public void onApplicationEvent(CriadorHeaderLocationEvent criador) {
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
				 .path("/{id}")
				 .buildAndExpand(criador.getId())
				 .toUri();
		criador.getRs().setHeader("Location", uri.toASCIIString());
	}
}
