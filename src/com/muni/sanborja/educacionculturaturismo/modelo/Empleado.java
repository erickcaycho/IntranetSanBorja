package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "idEmpleado", updatable = false, nullable = false)
	private int idEmpleado;


	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellipaterno")
	private String apellidoPat;

	@Column(name = "apellimaterno")
	private String apellidoMat;
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="detalle_horario_empleado",
			   joinColumns=@JoinColumn(name="idEmpleado",referencedColumnName="idempleado"),
			   inverseJoinColumns=@JoinColumn(name="idHorario",referencedColumnName="idhorario")
			   )
	private List<Horario> horarios;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="detalle_empleado_rol",
			   joinColumns=@JoinColumn(name="idEmpleado",referencedColumnName="idempleado"),
			   inverseJoinColumns=@JoinColumn(name="idrol",referencedColumnName="idrol")
			   )
	private List<Rol> roles;
	

	public String toString() {
		return "Nombre : "+ nombre +" "+ apellidoPat +" "+ apellidoMat;
	}
	
	
	
	
	
	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPat() {
		return apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	public String getApellidoMat() {
		return apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
}
