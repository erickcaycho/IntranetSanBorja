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
	@JoinColumn(name = "codEmpleado")
	private Empleado empleado;
	

	@Column(name = "idHorario")
	private int idHorario;
	
    /*@Id
    // If the join column is not define, it will default to class+id column (HELLO_WORLD_ID)
    // and you will get a  ORA-00904  invalid identifier
    // JoinColumn defines the name of the column in the table Hello_Cat
    @JoinColumn(name= "idHorario")
    private Horario horario;
    
    
    
	public Cronograma() {
    }
	
    
    public Cronograma(Horario horario) {
        this.setHorario(horario);
    }
    
    public Horario getHorario) {
        return horario;
    }
 
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    */
	
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

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}
	
	
	
	
	/*
  `codDetalleCronograma` int(11) NOT NULL AUTO_INCREMENT,
  `idHorario` int(11) NOT NULL,
  `tarea` varchar(40) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `fechaEjecucion` date DEFAULT NULL,
  `codEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`codDetalleCronograma`),
  FOREIGN KEY `FKcodEmpleado_id`  (codEmpleado) REFERENCES empleados(codEmpleado)*/
	
}
