package com.muni.sanborja.educacionculturaturismo.modelo;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "detalle_horario_material")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.material",
        joinColumns = @JoinColumn(name = "idmaterial")),
    @AssociationOverride(name = "primaryKey.horario",
        joinColumns = @JoinColumn(name = "idhorario")) })
public class Recurso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private RecursoCode primaryKey = new RecursoCode();
	private int cantidadUsar;


    @EmbeddedId
    public RecursoCode getPrimaryKey() {
        return primaryKey;
    }
 
    public void setPrimaryKey(RecursoCode primaryKey) {
        this.primaryKey = primaryKey;
    }
 
    @Transient
    public Material getMaterial() {
        return getPrimaryKey().getMaterial();
    }
 
    public void setMaterial(Material material) {
        getPrimaryKey().setMaterial(material);
    }
 
    @Transient
    public Horario getHorario() {
        return getPrimaryKey().getHorario();
    }
 
    public void setHorario(Horario horario) {
        getPrimaryKey().setHorario(horario);
    }

    @Column(name = "cantidad_usar")
	public int getCantidadUsar() {
		return cantidadUsar;
	}

	public void setCantidadUsar(int cantidadUsar) {
		this.cantidadUsar = cantidadUsar;
	}
	
}
