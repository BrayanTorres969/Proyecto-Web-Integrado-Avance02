package com.pe.incn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pe.incn.models.Residente;

import jakarta.transaction.Transactional;

@Repository
public interface ResidenteRepository extends JpaRepository<Residente, Long>  {
	
    @Query("SELECT r FROM Residente r WHERE r.estado = 1")
    List<Residente> findActiveResidentes();
    
 // Método para "eliminar" un residente cambiando su estado a 0
    @Modifying
    @Transactional
    @Query("UPDATE Residente r SET r.estado = 0 WHERE r.idResidente = :id")
    void softDeleteResidente(Long id);
    
    boolean existsByDni(String dni);

}
