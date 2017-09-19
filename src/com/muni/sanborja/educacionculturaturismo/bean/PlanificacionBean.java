package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanificacionDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;

@ManagedBean(name = "planificacionBean")
@SessionScoped 
public class PlanificacionBean implements Serializable{

	public static Logger log = Logger.getLogger(PlanificacionBean.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	private List<PlanificacionPeriodoActividad> planificacion;
	private Planificacion SelectedPlanificacion;
	
	public List<PlanificacionPeriodoActividad> getPlanificacion() {
		PlanificacionDao planificacionDao = new PlanificacionDaoImpl();
		planificacion = planificacionDao.listarPlanificacionPeriodoActividad();
		
		return planificacion;
	}
	
	public void setPlanificacion(List<PlanificacionPeriodoActividad> planificacion) {
		this.planificacion = planificacion;
	}
	
	public Planificacion getSelectedPlanificacion() {
		return SelectedPlanificacion;
	}
	public void setSelectedPlanificacion(Planificacion selectedPlanificacion) {
		SelectedPlanificacion = selectedPlanificacion;
	}
	
}
