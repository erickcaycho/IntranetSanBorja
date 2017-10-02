package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

public class RecursoCode implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	
	private Material material;
    private Horario horario;

    @ManyToOne(cascade = CascadeType.ALL)
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
 
   
}
