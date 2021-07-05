package com.eventoapp.eventoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventoapp.eventoapp.models.Amigos;
import com.eventoapp.eventoapp.models.Churras;

public interface BrothersRepository extends JpaRepository<Amigos, String>{
	

	Iterable<Amigos> findByChurras(Churras churras);
	
	

}
