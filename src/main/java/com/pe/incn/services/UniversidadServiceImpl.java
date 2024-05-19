package com.pe.incn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.incn.models.Universidad;
import com.pe.incn.repositories.UniversidadRepository;

@Service
public class UniversidadServiceImpl implements UniversidadService {
	
	@Autowired
	private UniversidadRepository universidadRepository;

	@Override
	public List<Universidad> getAllUniversidades() {
		return this.universidadRepository.findAll();
	}

	@Override
	public void saveUniversidad(Universidad universidad) {
		this.universidadRepository.save(universidad);
		
	}

	@Override
	public void deleteUniversidad(Long id) {
		this.universidadRepository.deleteById(id);		
	}

}
