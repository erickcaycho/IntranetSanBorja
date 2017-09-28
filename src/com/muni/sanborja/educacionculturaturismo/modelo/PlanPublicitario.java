package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PlanPublicitario")
public class PlanPublicitario implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
 	@GeneratedValue
	@Column(name = "idPlanPublicitario", updatable = false, nullable = false)
	private int idPlanPublicitario;

	@Column(name = "archivoRuta")
	private String archivoRuta;
	
	@Column(name = "descripcion")
	private String descripcion;

	@OneToOne
	@JoinColumn(name="idplanificacion")
	private Planificacion planificacion;
	
	public PlanPublicitario() {
    }

	public int getIdPlanPublicitario() {
		return idPlanPublicitario;
	}

	public void setIdPlanPublicitario(int idPlanPublicitario) {
		this.idPlanPublicitario = idPlanPublicitario;
	}

	public String getArchivoRuta() {
		return archivoRuta;
	}

	public void setArchivoRuta(String archivoRuta) {
		this.archivoRuta = archivoRuta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Planificacion getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(Planificacion planificacion) {
		this.planificacion = planificacion;
	}
}
