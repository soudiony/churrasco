package com.eventoapp.eventoapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import javax.validation.constraints.NotEmpty;

@Entity
public class Churras {
	
	

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	private String data;
	private String horario;
	
	@NotEmpty
	private String reuniao;
	
	private String local;
	
	@OneToMany
	private List<Amigos> amigos;
	//	//1 churras para muitos convidados..

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	public String getReuniao() {
		return reuniao;
	}



	public void setReuniao(String reuniao) {
		this.reuniao = reuniao;
	}



	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}
	
	
	
	
	public List<Amigos> getAmigos() {
		return amigos;
	}



	public void setAmigos(List<Amigos> amigos) {
		this.amigos = amigos;
	}	
	
	
	
	
	

}
