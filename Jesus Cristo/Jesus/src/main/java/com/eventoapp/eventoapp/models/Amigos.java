package com.eventoapp.eventoapp.models;

import javax.persistence.Entity;
import org.hibernate.validator.NotEmpty;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Amigos {

	@NotEmpty
	private String convidados;
	
	@Id
	@NotEmpty
	private Long rg;
	
	//Muitos convidados para 1 churrasco
	@ManyToOne  
	private Churras churras;

	
	//Get e Set
	

	public String getConvidados() {
		return convidados;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public void setConvidados(String convidados) {
		this.convidados = convidados;
	}

	public Churras getChurras() {
		return churras;
	}

	public void setChurras(Churras churras) {
		this.churras = churras;
	}

	

	
	
	
	
}
