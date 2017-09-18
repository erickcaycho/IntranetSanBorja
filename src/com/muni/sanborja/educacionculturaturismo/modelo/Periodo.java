package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Periodo")
public class Periodo implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	
	public Periodo(){
	}
	
	@Id
	@GeneratedValue
	@Column(name = "idperiodo", updatable = false, nullable = false)
	private int idPeriodo;
	
	@Column(name = "nomperiodo")
	private String nomPeriodo;

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public String getNomPeriodo() {
		return nomPeriodo;
	}

	public void setNomPeriodo(String nomPeriodo) {
		this.nomPeriodo = nomPeriodo;
	}
	
	
}
