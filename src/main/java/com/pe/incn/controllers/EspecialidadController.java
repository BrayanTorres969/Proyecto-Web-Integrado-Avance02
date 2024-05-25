package com.pe.incn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pe.incn.models.Especialidad;
import com.pe.incn.services.EspecialidadService;

@Controller
public class EspecialidadController {
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@GetMapping("/especialidades")
	public String verEspecialidades(Model modelo) {
		modelo.addAttribute("listaEspecialidades", especialidadService.getAllEspecialidades());
		return "lista_especialidad";
	}
	
	@GetMapping("/nuevaEspForm")
	public String nuevaEspForm(Model modelo) {
		Especialidad especialidad = new Especialidad();
		modelo.addAttribute("especialidad", especialidad);
		return "nueva_especialidad";
	}
	
	@PostMapping("/guardarEspecialidad")
	public String guardarEspecialidad(@ModelAttribute("especialidad") Especialidad esp, Model model) {
	    // Verifica si el código o la descripción están vacíos
	    if (esp.getCodigo().isEmpty() || esp.getDescripcion().isEmpty()) {
	        model.addAttribute("error", "Todos los campos son obligatorios");
	        return "nueva_especialidad";
	    }
	    
		if(especialidadService.existsByCodigo(esp.getCodigo())) {
			model.addAttribute("error", "El código de especialidad ya existe");
			return "nueva_especialidad";
		}
		especialidadService.saveEspecialidad(esp);
		return "redirect:/especialidades";
	}
	
	@GetMapping("/eliminarEspecialidad/{cod_esp}")
	public String eliminarEspecialidad(@PathVariable(value = "cod_esp") String codigo) {
		this.especialidadService.deleteEspecialidad(codigo);
		return "redirect:/especialidades";
	}
	
	@GetMapping("/especialidades/editar/{codigo}")
	public String mostrarFormActualizarEspecialidad(@PathVariable(value="codigo") String codigo, Model model) {
		model.addAttribute("especialidad", especialidadService.getEspecialidadByCodigo(codigo));
		return "actualizar_especialidad";
	}
	
	 @PostMapping("/especialidades/{codigo}")
	    public String actualizarEspecialidad(@PathVariable(value="codigo") String codigo,@ModelAttribute("especialidad") Especialidad esp, Model modelo) {
	        Especialidad especialidadExistente = especialidadService.getEspecialidadByCodigo(codigo);
	        especialidadExistente.setCodigo(esp.getCodigo());
	        especialidadExistente.setDescripcion(esp.getDescripcion());
	        
	       especialidadService.updateEspecialidad(especialidadExistente);
	        return "redirect:/especialidades";
	    }
	

}
