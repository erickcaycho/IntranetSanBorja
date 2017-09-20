package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;

@ManagedBean(name = "detallePlanificacionActividadBean")
@SessionScoped 
public class DetallePlanificacionActividadBean implements Serializable{

	public static Logger log = Logger.getLogger(DetallePlanificacionActividadBean.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	private Planificacion planificacion = new Planificacion();
	private int idperiodo;
	
	@PostConstruct
	public void init() {
		
		planificacion = new Planificacion();
		
		planificacion.setPeriodo(new Periodo());
		planificacion.setActividad(new Actividad());
		
	}
	
	public int getIdperiodo() {
		return idperiodo;
	}

	public void setIdperiodo(int idperiodo) {
		this.idperiodo = idperiodo;
	}

	public Planificacion getPlanificacion() {
		return planificacion;
	}


	public void setPlanificacion(Planificacion planificacion) {
		this.planificacion = planificacion;
	}
	
}
