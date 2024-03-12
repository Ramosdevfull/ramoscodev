package com.ramoscodev.demoapi.utils;

public class Greeting {
	private Long id;
	private String conteudo;
	
	
	public Greeting(Long id, String conteudo) {
		super();
		this.id = id;
		this.conteudo = conteudo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	@Override
	public String toString() {
		return "HelloWorldController [id=" + id + ", conteudo=" + conteudo + "]";
	}
}
