package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_horario_material")
public class Recurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idmaterial")
	private Material material;
	
	@Id
	@ManyToOne
	@JoinColumn(name="idhorario")
	private Horario horario;
	
	@Column(name = "cantidad_usar")
	private int cantidadUsar;

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public int getCantidadUsar() {
		return cantidadUsar;
	}

	public void setCantidadUsar(int cantidadUsar) {
		this.cantidadUsar = cantidadUsar;
	}
	
}
