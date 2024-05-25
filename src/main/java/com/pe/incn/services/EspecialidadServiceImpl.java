package com.pe.incn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.incn.models.Especialidad;
import com.pe.incn.repositories.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {
	
	@Autowired
	private EspecialidadRepository especialidadRepository;

	@Override
	public List<Especialidad> getAllEspecialidades() {
		return this.especialidadRepository.findAll();
	}

	@Override
	public void saveEspecialidad(Especialidad especialidad) {
		this.especialidadRepository.save(especialidad);
		
	}

	@Override
	public void deleteEspecialidad(String codigo) {
		this.especialidadRepository.deleteById(codigo);
		
	}

	@Override
	public Especialidad getEspecialidadByCodigo(String codigo) {
		return especialidadRepository.findById(codigo).get();
	}

	@Override
	public void updateEspecialidad(Especialidad especialidad) {
		this.especialidadRepository.save(especialidad);
		
	}

	@Override
	public boolean existsByCodigo(String codigo) {
		return especialidadRepository.existsByCodigo(codigo);
	}

}
