package com.pe.incn.services;

import java.util.List;

import com.pe.incn.models.Especialidad;

public interface EspecialidadService {
	
	List<Especialidad> getAllEspecialidades();
	void saveEspecialidad(Especialidad especialidad);
	void updateEspecialidad(Especialidad especialidad);
	void deleteEspecialidad(String codigo);
	Especialidad getEspecialidadByCodigo(String codigo);
	boolean existsByCodigo(String codigo);
	
	

}
