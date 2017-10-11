package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Dia;

public interface DiaDao {
	
	public boolean asignarDia(Dia dia);
	public List<Dia> listarDias(int idHorario);
	public boolean eliminarRecurso(int idDia);
}
