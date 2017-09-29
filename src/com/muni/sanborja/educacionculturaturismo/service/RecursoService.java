package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;

public interface RecursoService {
	
	public List<Material> listarMateriales(String material);
	public boolean guardarRecurso(Recurso recurso);

}
