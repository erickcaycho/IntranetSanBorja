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
@Table(name = "Sede")
public class Sede implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Sede(){
	}
	
	@Id
	@GeneratedValue
	@Column(name = "idsede", updatable = false, nullable = false)
	private int idSede;
	
	@Column(name = "nombresede")
	private String nombreSede;
	
	@OneToMany
	private Set<Ambiente> ambiente;

	public int getIdSede() {
		return idSede;
	}

	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}

	public Set<Ambiente> getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Set<Ambiente> ambiente) {
		this.ambiente = ambiente;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	
}
