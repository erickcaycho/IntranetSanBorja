package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Horario;

public interface HorarioService {

	public boolean createHorario(Horario horario);
	public List<Horario> listarHorario(int idPlanificacion);
	
}
