package com.muni.sanborja.educacionculturaturismo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;

@ManagedBean(name = "planificacionBean")
@SessionScoped 
public class PlanificacionBean {

	public static Logger log = Logger.getLogger(PlanificacionBean.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	private List<Planificacion> planificacion;
	private Planificacion SelectedPlanificacion;
	
	public List<Planificacion> getPlanificacion() {
		return planificacion;
	}
	public void setPlanificacion(List<Planificacion> planificacion) {
		this.planificacion = planificacion;
	}
	
	public Planificacion getSelectedPlanificacion() {
		return SelectedPlanificacion;
	}
	public void setSelectedPlanificacion(Planificacion selectedPlanificacion) {
		SelectedPlanificacion = selectedPlanificacion;
	}
	
	
	
	
}
