package com.eventoapp.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapp.eventoapp.models.Amigos;

public interface BrothersRepository extends JpaRepository<Amigos, String>{
	

}
