package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlanificacionPeriodoActividad implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idPlanificacion;
	private String nomPeriodo;
	private Date fechaCreacion;
	private Date fechaPlanificacion;
	private Date fechaAprobacion;
	private Date fechaRechazo;
	private Date fechaAnulacion;
	private Date fechaEjecucion;
	private String nomActividad;
	private String nomTipoActividad;
	private String estado;
	
	
	
	public int getIdPlanificacion() {
		return idPlanificacion;
	}
	public void setIdPlanificacion(int idPlanificacion) {
		this.idPlanificacion = idPlanificacion;
	}
	public String getNomPeriodo() {
		return nomPeriodo;
	}
	public void setNomPeriodo(String nomPeriodo) {
		this.nomPeriodo = nomPeriodo;
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
	public Date getFechaAprobacion() {
		return fechaAprobacion;
	}
	public void setFechaAprobacion(Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public Date getFechaRechazo() {
		return fechaRechazo;
	}
	public void setFechaRechazo(Date fechaRechazo) {
		this.fechaRechazo = fechaRechazo;
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
	public String getNomActividad() {
		return nomActividad;
	}
	public void setNomActividad(String nomActividad) {
		this.nomActividad = nomActividad;
	}
	public String getNomTipoActividad() {
		return nomTipoActividad;
	}
	public void setNomTipoActividad(String nomTipoActividad) {
		this.nomTipoActividad = nomTipoActividad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
