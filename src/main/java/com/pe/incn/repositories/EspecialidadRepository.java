package com.pe.incn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.incn.models.Especialidad;



public interface EspecialidadRepository extends JpaRepository<Especialidad, String>  {
	
	Especialidad getByCodigo(String codigo);
	boolean existsByCodigo(String codigo);

}
