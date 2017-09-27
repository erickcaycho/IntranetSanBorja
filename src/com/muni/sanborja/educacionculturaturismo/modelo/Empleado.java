package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "codEmpleado", updatable = false, nullable = false)
	private int codEmpleado;


	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidoPat")
	private String apellidoPat;

	@Column(name = "apellidoMat")
	private String apellidoMat;
	

	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}
	
}
