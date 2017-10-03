package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;

public interface CronogramaDao {

	public boolean createCronograma(Cronograma cronograma);
	public List<Cronograma> listarCronograma(int idHorario);
	public boolean delete(Cronograma cronograma);

	/*public boolean create(Planificacion planificacion);
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad(int idperiodo, int estado);*/
	
}
