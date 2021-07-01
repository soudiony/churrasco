package com.eventoapp.eventoapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventoapp.eventoapp.models.Churras;

@Repository


public interface EventoRepository extends JpaRepository<Churras, Long>{
	Churras procId(long id); //instanciar em controller - busca

	

}
