package com.pe.incn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.incn.models.Residente;
import com.pe.incn.repositories.ResidenteRepository;


@Service
public class ResidenteServiceImpl implements ResidenteService {
	
	@Autowired
    private ResidenteRepository residenteRepository;

	@Override
	public List<Residente> getAllResidentes() {
		return residenteRepository.findActiveResidentes();
	}

	@Override
	public Residente getResidenteById(Long id) {
		return residenteRepository.findById(id).orElse(null);
	}

	@Override
	public void saveResidente(Residente residente) {
		residenteRepository.save(residente);	
	}

	@Override
	public void deleteResidente(Long id) {
		residenteRepository.softDeleteResidente(id);
		
	}

	@Override
	public boolean existeConDni(String codigo) {
		return residenteRepository.existsByDni(codigo);
	}

}
