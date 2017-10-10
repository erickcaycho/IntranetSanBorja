package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Dia;

public interface DiaService {

	public boolean asignarDia(Dia dia);
	public List<Dia> listaDias(int idHorario);
}
