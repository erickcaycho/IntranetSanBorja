package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Dia")
public class Dia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "iddia", updatable = false, nullable = false)
	private int idDia;
	
	@Column(name = "fechainicio")
	private String fechaInicio;
	
	@Column(name = "fechafin")
	private String fechaFin;
	
	@Column(name = "dia")
	private String dia;
	
	@ManyToOne
	@JoinColumn(name="idhorario")
	private Horario horario;

	public int getIdDia() {
		return idDia;
	}

	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Dia() {
		super();
	}
	
}
