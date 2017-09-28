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
@Table(name = "Material")
public class Material implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idmaterial", updatable = false, nullable = false)
	private int idMaterial;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "cantidad_disponible")
	private int cantidadDisponible;
	
	@OneToMany
	private Set<Recurso> recurso;

	public int getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Material() {
	}

	public Set<Recurso> getRecurso() {
		return recurso;
	}

	public void setRecurso(Set<Recurso> recurso) {
		this.recurso = recurso;
	}
	
}
