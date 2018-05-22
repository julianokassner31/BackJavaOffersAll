package br.com.offersall.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class CriadorHeaderLocationEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = 1L;

	private HttpServletResponse rs;
	private Integer id;
	
	public CriadorHeaderLocationEvent(Object source, HttpServletResponse rs, Integer id) {
		super(source);
		this.rs = rs;
		this.id = id;
	}

	public HttpServletResponse getRs() {
		return rs;
	}

	public Integer getId() {
		return id;
	}
}
