package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;

public interface PlanificacionDao {

	public boolean create(Planificacion planificacion);
	public List<Planificacion> listarPlanificacionPeriodoActividad();
	
}
