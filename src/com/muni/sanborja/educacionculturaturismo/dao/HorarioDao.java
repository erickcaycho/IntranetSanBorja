package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Horario;

public interface HorarioDao {

	public boolean createHorario(Horario horario);
	public List<Horario> listarHorario(int idPlanificacion);
	
}
