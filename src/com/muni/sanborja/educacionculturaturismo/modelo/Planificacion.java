package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Planificacion")
public class Planificacion  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
 	@GeneratedValue
 	@Column(name = "idplanificacion", updatable = false, nullable = false)
	private int idPlanificacion;
	
	@Column(name = "fechacreacion")
	private Date fechaCreacion;
	
	@Column(name = "fechaplanificacion")
	private Date fechaPlanificacion;
	
	@Column(name = "fecharechazo")
	private Date fechaRechazo;
	
	@Column(name = "fechaaprobacion")
	private Date fechaAprobacion;
	
	@Column(name = "fechaanulacion")
	private Date fechaAnulacion;
	
	@Column(name = "fechaejecucion")
	private Date fechaEjecucion;
	
	@Column(name = "estado")
	private int estado;

	@ManyToOne
	@JoinColumn(name="idactividad")
	private Actividad actividad;
	
	@ManyToOne
	@JoinColumn(name="idperiodo")
	private Periodo periodo;
	
	@Transient
	private String estadodetalle;

	/*
	 * @OneToMany
	private Set<Horario> horario;
	
	 * */
	
	public Planificacion(){
	}

	public int getIdPlanificacion() {
		return idPlanificacion;
	}

	public void setIdPlanificacion(int idPlanificacion) {
		this.idPlanificacion = idPlanificacion;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaPlanificacion() {
		return fechaPlanificacion;
	}

	public void setFechaPlanificacion(Date fechaPlanificacion) {
		this.fechaPlanificacion = fechaPlanificacion;
	}

	public Date getFechaRechazo() {
		return fechaRechazo;
	}

	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
	}

	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}

	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}

	public Date getFechaAnulacion() {
		return fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}
	
	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public String getEstadodetalle() {
		if(this.estado==1){
			estadodetalle="Pendiente";
		}else if(this.estado==2){
			estadodetalle="Planificado";
		}else if(this.estado==3){
			estadodetalle="Aprobado";
		}else if(this.estado==4){
			estadodetalle="Rechazado";
		}else if(this.estado==5){
			estadodetalle="Ejecutado";
		}else if(this.estado==6){
			estadodetalle="Anulado";
		}
		return estadodetalle;
	}

	public void setEstadodetalle(String estadodetalle) {
		this.estadodetalle = estadodetalle;
	}
	
	/*
	 * public Set<Horario> getHorario() {
		return horario;
	}

	public void setHorario(Set<Horario> horario) {
		this.horario = horario;
	}
	
	 * */
	

}
