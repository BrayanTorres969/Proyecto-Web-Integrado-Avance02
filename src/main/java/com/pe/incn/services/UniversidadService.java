package com.pe.incn.services;

import java.util.List;

import com.pe.incn.models.Universidad;

public interface UniversidadService {
	
	List<Universidad> getAllUniversidades();
	void saveUniversidad(Universidad universidad);

}
