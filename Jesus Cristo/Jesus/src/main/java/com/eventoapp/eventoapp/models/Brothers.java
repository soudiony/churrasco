package com.eventoapp.eventoapp.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Brothers {

	@Id
	private String rg;
	private String convidados;
	
	//Muitos convidados para 1 churrasco
	@ManyToOne  
	private Churras quemvai;
	
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getConvidados() {
		return convidados;
	}
	public void setConvidados(String convidados) {
		this.convidados = convidados;
	}
	public Churras getQuemvai() {
		return quemvai;
	}
	public void setQuemvai(Churras quemvai) {
		this.quemvai = quemvai;
	}
	
	
	
	
}
