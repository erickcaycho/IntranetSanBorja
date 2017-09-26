package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Horario")
public class Horario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Horario(){
	}
	
	@Id
	@GeneratedValue
	@Column(name = "idhorario", updatable = false, nullable = false)
	private int idHorario;
	
	@Column(name = "fechainicio")
	private Date fechaInicio;
	
	@Column(name = "fechaFin")
	private Date fechafin;
	
	@Column(name = "edadmin")
	private int edadMin;
	
	@Column(name = "edadmax")
	private int edadMax;
	
	@Column(name = "cantsesion")
	private int cantsesion;
	
	@Column(name = "horassesion")
	private int horassesion;
	
	@Column(name = "vacantemin")
	private int vacantemin;
	
	@Column(name = "vacantemax")
	private int vacantemax;
	
	@Column(name = "precio")
	private double precio;

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public int getEdadMax() {
		return edadMax;
	}

	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}

	public int getCantsesion() {
		return cantsesion;
	}

	public void setCantsesion(int cantsesion) {
		this.cantsesion = cantsesion;
	}

	public int getHorassesion() {
		return horassesion;
	}

	public void setHorassesion(int horassesion) {
		this.horassesion = horassesion;
	}

	public int getVacantemin() {
		return vacantemin;
	}

	public void setVacantemin(int vacantemin) {
		this.vacantemin = vacantemin;
	}

	public int getVacantemax() {
		return vacantemax;
	}

	public void setVacantemax(int vacantemax) {
		this.vacantemax = vacantemax;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}