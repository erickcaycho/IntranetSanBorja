package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;

public interface CronogramaService {

	public boolean createCronograma(Cronograma cronograma);
	public List<Cronograma> listarCronograma(int idHorario,int idCronograma);
	public boolean delete(Cronograma cronograma);

	/*public boolean create(Planificacion planificacion);
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad(int idperiodo, int estado);*/
	
}
