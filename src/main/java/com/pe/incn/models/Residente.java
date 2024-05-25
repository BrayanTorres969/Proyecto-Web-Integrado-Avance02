package com.pe.incn.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_residentes")
public class Residente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idResidente;

	@Column(nullable = false, unique = true, length = 8)
	private String dni;

	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
    private String apellido;
	
	private String direccion;
	
	@Temporal(TemporalType.DATE)
    private Date fechaIngreso;
	
	@Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
	
	@ManyToOne
    @JoinColumn(name = "especialidad_id")
    private Especialidad especialidad;
	
	@ManyToOne
    @JoinColumn(name = "universidad_id")
    private Universidad universidad;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
	private byte estado = 1;

	public Residente() {
	}

	public Long getIdResidente() {
		return idResidente;
	}

	public void setIdResidente(Long idResidente) {
		this.idResidente = idResidente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
	}

	public byte getEstado() {
		return estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}
	
	
	
	

}
