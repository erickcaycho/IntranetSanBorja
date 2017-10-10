package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;

public interface PlanificacionService {

	public boolean create(Planificacion planificacion);
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad(int idperiodo, int estado);
	public boolean validarActividadPorPeriodo(int idPeriodo, int idTipoActividad, int idActividad);
	public boolean delete(Planificacion planificacion);
	public boolean updatePlanificacion(Planificacion planificacion);
	public Planificacion buscar(int idPlanificacion);
}
