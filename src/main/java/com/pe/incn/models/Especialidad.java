package com.pe.incn.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_especialidades")
public class Especialidad {
	
	@Id
	@Column(name="cod_especialidad",unique=true, nullable=false, length=6)
	private String codigo;
	@Column(unique=true, nullable=false, length=150)
	private String descripcion;
	
	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.ALL)
    private List<Residente> residentes;
	
	public Especialidad() {
	}

	public Especialidad(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
	

}
