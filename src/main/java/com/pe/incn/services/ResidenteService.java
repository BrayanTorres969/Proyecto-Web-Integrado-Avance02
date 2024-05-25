package com.pe.incn.services;

import java.util.List;

import com.pe.incn.models.Residente;

public interface ResidenteService {
	
	List<Residente> getAllResidentes();
    Residente getResidenteById(Long id);
    void saveResidente(Residente residente);
    void deleteResidente(Long id);

}
