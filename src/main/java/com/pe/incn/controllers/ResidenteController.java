package com.pe.incn.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;


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
	    
	    if(residenteService.existeConDni(residente.getDni())) {
	    	
	    	model.addAttribute("error", "Este DNI ya esta en uso");
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
    

    @GetMapping("/residentes/editar/{id}")
    public String mostrarFormActualizarResi(@PathVariable(value = "id") Long id, Model model) {
        Residente residente = residenteService.getResidenteById(id);
        model.addAttribute("residente", residente);
        model.addAttribute("listaUniversidades", universidadService.getAllUniversidades());
        model.addAttribute("listaEspecialidades", especialidadService.getAllEspecialidades());
        return "actualizar_residente";
    }
    
    
    @PostMapping("/residentes/{id}")
    public String actualizarResidente(@PathVariable(value="id") Long id,@ModelAttribute("residente") Residente res, Model modelo) {
    	Residente residenteExistente = residenteService.getResidenteById(id);
    	residenteExistente.setNombre(res.getNombre());
    	residenteExistente.setApellido(res.getApellido());
    	residenteExistente.setDireccion(res.getDireccion());
    	residenteExistente.setFechaNacimiento(res.getFechaNacimiento());
    	residenteExistente.setFechaIngreso(res.getFechaIngreso());
    	residenteExistente.setUniversidad(res.getUniversidad());
    	residenteExistente.setEspecialidad(res.getEspecialidad());
    	
    	residenteService.updateResidente(residenteExistente);	
    	return "redirect:/residentes";
    }
    
    @GetMapping("/residentes/perfil/{id}")
    public String mostrarPerfilResi(@PathVariable(value = "id") Long id, Model model) {
        Residente residente = residenteService.getResidenteById(id);

     // Convertir java.sql.Date a java.time.LocalDate
        Date fechaNacimiento = residente.getFechaNacimiento();
        LocalDate fechaNacimientoLocalDate = fechaNacimiento.toLocalDate();

        // Calcular la edad
        int edad = Period.between(fechaNacimientoLocalDate, LocalDate.now()).getYears();      
        model.addAttribute("residente", residente);
        model.addAttribute("edad", edad);
        return "perfil_residente";
    }

}
