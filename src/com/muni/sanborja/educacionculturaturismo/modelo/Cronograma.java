package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cronograma")
public class Cronograma implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
 	@GeneratedValue
	@Column(name = "idCronograma", updatable = false, nullable = false)
	private int idCronograma;

	@Column(name = "tarea")
	private String tarea;
	
	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "fechaInicio")
	private Date fechaInicio;
	
	@Column(name = "fechaFin")
	private Date fechaFin;
	
	@Column(name = "fechaEjecucion")
	private Date fechaEjecucion;
	
	@OneToOne
	@JoinColumn(name = "idEmpleado")
	private Empleado empleado;
	
	@OneToOne
	@JoinColumn(name = "idhorario")
	private Horario horario;
	
	public Cronograma() {
    }

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setIdCronograma(int idCronograma) {
		this.idCronograma = idCronograma;
	}

	public int getIdCronograma() {
		return idCronograma;
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

}
