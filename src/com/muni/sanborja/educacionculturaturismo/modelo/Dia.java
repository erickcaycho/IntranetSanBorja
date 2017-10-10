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
	
	@Column(name = "horainicio")
	private String horaInicio;
	
	@Column(name = "horafin")
	private String horaFin;
	
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

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
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
