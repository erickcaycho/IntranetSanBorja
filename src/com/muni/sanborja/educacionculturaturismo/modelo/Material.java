package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	private Set<Recurso> recurso;
	
}