package com.pe.incn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pe.incn.models.Universidad;
import com.pe.incn.services.UniversidadService;


@Controller
public class UniversidadController {
	
	@Autowired
	private UniversidadService uniService;
	
	
	@GetMapping("/universidades")
	public String verUniversidades(Model modelo) {
		modelo.addAttribute("listaUniversidades",uniService.getAllUniversidades());
		return "lista_uni";
	}
	
	@GetMapping("/nuevaUniForm")
	public String nuevaUniForm(Model modelo) {
		Universidad universidad = new Universidad();
		modelo.addAttribute("universidad",universidad);
		return "nueva_universidad";
	}
	
	@PostMapping("guardarUniversidad")
	public String guardarEmpleado(@ModelAttribute("universidad") Universidad uni) {
		uniService.saveUniversidad(uni);
		return "redirect:/universidades";
	}
	
	@GetMapping("/eliminarUniversidad")
	public String eliminarUniversidad(@PathVariable(value="id_uni") Long id) {
		//this.uniService.deleteUniversidad(id);
		return "redirect:/universidades";
	}

}
