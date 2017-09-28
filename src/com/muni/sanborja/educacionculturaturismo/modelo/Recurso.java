package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_horario_material")
public class Recurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany
	@JoinColumn(name="idmaterial")
	private Material idMaterial;
	
	@OneToMany
	@JoinColumn(name="idhorario")
	private Horario idHorario;
	
	@Column(name = "cantidad_usar")
	private int cantidadUsar;
	
}
