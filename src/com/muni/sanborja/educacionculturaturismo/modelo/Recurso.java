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
@Table(name = "Recurso")
public class Recurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "idrecurso", updatable = false, nullable = false)
	private int idRecurso;
	
	@Column(name = "cantidadusar")
	private int cantidadUsar;
	
	@ManyToOne
	@JoinColumn(name="idmaterial")
	private Material idMaterial;

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public int getCantidadUsar() {
		return cantidadUsar;
	}

	public void setCantidadUsar(int cantidadUsar) {
		this.cantidadUsar = cantidadUsar;
	}

	public Material getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Material idMaterial) {
		this.idMaterial = idMaterial;
	}
	
	
}
