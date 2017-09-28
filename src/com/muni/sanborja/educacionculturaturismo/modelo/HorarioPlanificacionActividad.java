package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HorarioPlanificacionActividad implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private int idHorario;
	private String nombreSede;
	private String nombreAmbiente;
	private String dirigido;
	private int cantidadSesion;
	private int horaSesion;
	private int vacanteMin;
	private int vacanteMax;
	private Double precio;
	private Date fechaInicio;
	private Date fechaFin;
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public String getNombreAmbiente() {
		return nombreAmbiente;
	}
	public void setNombreAmbiente(String nombreAmbiente) {
		this.nombreAmbiente = nombreAmbiente;
	}
	public String getDirigido() {
		return dirigido;
	}
	public void setDirigido(String dirigido) {
		this.dirigido = dirigido;
	}
	public int getCantidadSesion() {
		return cantidadSesion;
	}
	public void setCantidadSesion(int cantidadSesion) {
		this.cantidadSesion = cantidadSesion;
	}
	public int getHoraSesion() {
		return horaSesion;
	}
	public void setHoraSesion(int horaSesion) {
		this.horaSesion = horaSesion;
	}
	public int getVacanteMin() {
		return vacanteMin;
	}
	public void setVacanteMin(int vacanteMin) {
		this.vacanteMin = vacanteMin;
	}
	public int getVacanteMax() {
		return vacanteMax;
	}
	public void setVacanteMax(int vacanteMax) {
		this.vacanteMax = vacanteMax;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
}
