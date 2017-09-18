package com.muni.sanborja.educacionculturaturismo.modelo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPOACTIVIDAD")
public class TipoActividad {

	@Id
 	@GeneratedValue
	@Column(name = "idtipoactividad", updatable = false, nullable = false)
	private int idTipoActividad;
	
	@Column(name = "nomtipoactividad")	
	private String nomTipoActividad;
	
	@Column(name = "descripcion")	
	private String descripcion;

	private Set<Actividad> actividades;
	
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
	
	@OneToMany(mappedBy = "tipoactividad", cascade = CascadeType.ALL)
	public Set<Actividad> getActividades() {
		return actividades;
	}
 
	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	
}
