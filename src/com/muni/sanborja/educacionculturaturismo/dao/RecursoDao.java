package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;

public interface RecursoDao {
	
	public List<Material> listarMateriales(String material);
	public List<Recurso> listarRecursos(int idHorario);
	public boolean guardarRecurso(Recurso recurso);
	public boolean actualizarCantidadMaterial(Material material, int cantidad);
	public boolean actualizarCantidadMaterial(Recurso recurso);
	public boolean eliminarRecurso(Recurso recurso);
}
