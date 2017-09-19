package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;

public interface PlanificacionDao {

	public boolean create(Planificacion planificacion);
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad();
	
}
