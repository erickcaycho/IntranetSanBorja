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
@Table(name = "Ambiente")
public class Ambiente  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
 	@GeneratedValue
 	@Column(name = "idambiente", updatable = false, nullable = false)
	private int idAmbiente;
	
	@Column(name = "nomambiente")
	private String nomAmbiente;
	
	@ManyToOne
	@JoinColumn(name="idsede")
	private Sede sede;
	
	@Column(name = "capacidad")
	private int capacidad;
	
	public int getIdAmbiente() {
		return idAmbiente;
	}

	public void setIdAmbiente(int idAmbiente) {
		this.idAmbiente = idAmbiente;
	}

	public String getNomAmbiente() {
		return nomAmbiente;
	}

	public void setNomAmbiente(String nomAmbiente) {
		this.nomAmbiente = nomAmbiente;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Ambiente(){
	}
	
}
