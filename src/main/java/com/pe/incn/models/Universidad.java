package com.pe.incn.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_universidades")
public class Universidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_universidad;
	
	@Column(name="nom_universidad",unique = true, nullable=false, length=250)
    private String nombre;

	public Universidad() {
	}

	public Universidad(Long id_universidad, String nombre) {
		super();
		this.id_universidad = id_universidad;
		this.nombre = nombre;
	}

	public Long getId_universidad() {
		return id_universidad;
	}

	public void setId_universidad(Long id_universidad) {
		this.id_universidad = id_universidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
