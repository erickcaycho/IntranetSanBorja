package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TipoActividad")
public class TipoActividad implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
 	@GeneratedValue
	@Column(name = "idtipoactividad", updatable = false, nullable = false)
	private int idTipoActividad;
	
	@Column(name = "nomtipoactividad")	
	private String nomTipoActividad;
	
	@Column(name = "descripcion")	
	private String descripcion;

	@OneToMany
	private Set<Actividad> actividad;
	
	public TipoActividad(){
	}
	
	public int getIdTipoActividad() {
		return idTipoActividad;
	}

	public void setIdTipoActividad(int idTipoActividad) {
		this.idTipoActividad = idTipoActividad;
	}

	public String getNomTipoActividad() {
		return nomTipoActividad;
	}

	public void setNomTipoActividad(String nomTipoActividad) {
		this.nomTipoActividad = nomTipoActividad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Actividad> getActividad() {
		return actividad;
	}

	public void setActividad(Set<Actividad> actividad) {
		this.actividad = actividad;
	}
	
}
