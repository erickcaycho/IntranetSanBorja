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
@Table(name = "motivoRechazo")
public class MotivoRechazo  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
 	@GeneratedValue
 	@Column(name = "idmotivo", updatable = false, nullable = false)
	private int idMotivo;
	
	private String descMotivo;

	public MotivoRechazo(){
	}
	
	@OneToMany
	private Set<Planificacion> planificacion;

	public int getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescMotivo() {
		return descMotivo;
	}

	public void setDescMotivo(String descMotivo) {
		this.descMotivo = descMotivo;
	}

	public Set<Planificacion> getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(Set<Planificacion> planificacion) {
		this.planificacion = planificacion;
	}

}
