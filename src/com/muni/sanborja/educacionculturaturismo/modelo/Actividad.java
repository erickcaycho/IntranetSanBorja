package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idactividad", updatable = false, nullable = false)
	private int idActividad;
	
	@Column(name = "nomactividad")
	private String nomActividad;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "imagen")
	private String imagen;
	
	@Column(name = "objetivo")
	private String objetivo;
	
	@ManyToOne
	@JoinColumn(name="idtipoactividad")
	private TipoActividad tipoActividad;
	
	
	public int getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}
	public String getNomActividad() {
		return nomActividad;
	}
	public void setNomActividad(String nomActividad) {
		this.nomActividad = nomActividad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
}
