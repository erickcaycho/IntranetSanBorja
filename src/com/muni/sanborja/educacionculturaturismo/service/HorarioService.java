package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.HorarioPlanificacionActividad;

public interface HorarioService {

	public boolean createHorario(Horario horario);
	public List<Horario> listarHorario(int idPlanificacion);
	public List<HorarioPlanificacionActividad> listarHorarioPlanificacionActividad();
	
}
