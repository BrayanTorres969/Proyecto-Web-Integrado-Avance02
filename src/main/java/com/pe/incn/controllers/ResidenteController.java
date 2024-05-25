package com.pe.incn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pe.incn.models.Residente;
import com.pe.incn.services.EspecialidadService;
import com.pe.incn.services.ResidenteService;
import com.pe.incn.services.UniversidadService;

@Controller
public class ResidenteController {
	
    @Autowired
    private ResidenteService residenteService;

    @Autowired
    private UniversidadService universidadService;

    @Autowired
    private EspecialidadService especialidadService;
    
    @GetMapping("/residentes")
    public String verResidentes(Model modelo) {
        modelo.addAttribute("listaResidentes", residenteService.getAllResidentes());
        return "lista_residentes";
    }
    
    @GetMapping("/nuevoResidenteForm")
    public String nuevoResidenteForm(Model modelo) {
        Residente residente = new Residente();
        modelo.addAttribute("residente", residente);
        modelo.addAttribute("listaUniversidades", universidadService.getAllUniversidades());
        modelo.addAttribute("listaEspecialidades", especialidadService.getAllEspecialidades());
        return "nuevo_residente";
    }
    
    @PostMapping("/guardarResidente")
    public String guardarResidente(@ModelAttribute("residente") Residente residente, Model model) {
    	// Validar campos obligatorios
	    if (residente.getDni().isEmpty() || residente.getNombre().isEmpty() || residente.getApellido().isEmpty()
	    	|| residente.getDireccion().isEmpty()) {
	        model.addAttribute("error", "Todos los campos son obligatorios");
	        model.addAttribute("listaUniversidades", universidadService.getAllUniversidades());
	        model.addAttribute("listaEspecialidades", especialidadService.getAllEspecialidades());
	        return "nuevo_residente";
	    }	    
	 // Validar formato del DNI
	    String dniPattern = "\\d{8}";
	    if (!residente.getDni().matches(dniPattern)) {
	        model.addAttribute("error", "El DNI debe tener exactamente 8 caracteres numéricos");
	        model.addAttribute("listaUniversidades", universidadService.getAllUniversidades());
	        model.addAttribute("listaEspecialidades", especialidadService.getAllEspecialidades());
	        return "nuevo_residente";
	    }
        residenteService.saveResidente(residente);
        return "redirect:/residentes";
    }
    
    @GetMapping("/eliminarResidente/{id_residente}")
    public String eliminarResidente(@PathVariable(value = "id_residente") Long id) {
        this.residenteService.deleteResidente(id);
        return "redirect:/residentes";
    }
    
    /*
    @GetMapping("/actualizarResidente/{id_residente}")
    public String actualizarResidente(@PathVariable(value = "id_residente") Long id, Model model) {
        Residente residente = residenteService.getResidenteById(id);
        model.addAttribute("residente", residente);
        model.addAttribute("listaUniversidades", universidadService.getAllUniversidades());
        model.addAttribute("listaEspecialidades", especialidadService.getAllEspecialidades());
        return "actualizar_residente";
    }*/

}
