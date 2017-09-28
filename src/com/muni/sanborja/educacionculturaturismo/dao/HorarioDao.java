package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.HorarioPlanificacionActividad;

public interface HorarioDao {

	public boolean createHorario(Horario horario);
	public List<Horario> listarHorario(int idPlanificacion);
	public List<HorarioPlanificacionActividad> listarHorarioPlanificacionActividad();
	
}
