package com.eventoapp.eventoapp.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eventoapp.eventoapp.models.Amigos;
import com.eventoapp.eventoapp.models.Churras;
import com.eventoapp.eventoapp.repository.BrothersRepository;
import com.eventoapp.eventoapp.repository.EventoRepository;

@Controller

public class EventoController {

	@Autowired
	private EventoRepository eventoRep;

	@Autowired
	private BrothersRepository brothersRep;

	@RequestMapping(value = "/CadastraReuniao", method = RequestMethod.GET)
	public String form() {
		return "Reuniao/formEvento";
	}

	@RequestMapping(value = "/CadastraReuniao", method = RequestMethod.POST) // Cadastra no Banco
	public String form(@Valid Churras churras, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Houve Errs");
			return "Reuniao/formEvento";
		}
		eventoRep.save(churras);
		return "Reuniao/formEvento";

	}

	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {

		ModelAndView mv = new ModelAndView("index");
		Iterable<Churras> eventos = eventoRep.findAll();

		mv.addObject("eventos", eventos);

		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // @PageableDefault retorna 1 campo do banco
	public ModelAndView detalhesChurras(@PathVariable("id") long id) {
		Churras eventos = eventoRep.findById(id); // findBy.ID repository para fazer busca especifica

		ModelAndView mv = new ModelAndView("Reuniao/detalhesChurras");
		mv.addObject("eventos", eventos);

		// Mostra na View os convidados os brody							// Iterable! Faz uma busca
		Iterable<Amigos> mostraAmigos = brothersRep.findByChurras(eventos); // findBy.Churras! criei no repository
		mv.addObject("amigos", mostraAmigos);

		return mv;


	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesChurrasPost(@PathVariable("id") long id, @Valid Amigos amigos, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os Campos");
			return "redirect:/{id}";
		} 
		
		Churras eventos = eventoRep.findById(id);
		amigos.setChurras(eventos);
		brothersRep.save(amigos);
		attributes.addFlashAttribute("mensagem", "Brody cadastrado com sucesso.");
		return "redirect:/{id}";
		}
	

}
