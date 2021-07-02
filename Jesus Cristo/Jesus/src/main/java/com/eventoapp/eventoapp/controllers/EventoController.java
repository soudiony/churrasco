package com.eventoapp.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventoapp.eventoapp.models.Churras;

import com.eventoapp.eventoapp.repository.EventoRepository;

@Controller

public class EventoController {

	@Autowired
	private EventoRepository eventoRep;

	@RequestMapping(value = "/CadastraReuniao", method = RequestMethod.GET)
	public String form() {
		return "Reuniao/formEvento";
	}

	@RequestMapping(value = "/CadastraReuniao", method = RequestMethod.POST) // Cadastra no Banco
	public String form(Churras evento) {

		eventoRep.save(evento);
		return "Reuniao/formEvento";

	}

	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {

		ModelAndView mv = new ModelAndView("index");
		Iterable<Churras> eventos = eventoRep.findAll();

		mv.addObject("eventos", eventos);

		System.out.println("mv na veia-->" + mv);
		return mv;
	}

	@RequestMapping("/{id}") // @PageableDefault retorna 1 campo do banco
	public ModelAndView detalhesChurras(@PathVariable("id") long id) {
		Churras churras = eventoRep.findById(id); //Metodo passado no controller para fazer busca especifica

		ModelAndView mv = new ModelAndView("Reuniao/detalhesChurras");
		mv.addObject("eventos", churras);
		return mv;

	}

}
