package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;

public interface RecursoService {
	
	public List<Material> listarMateriales(String material);
	public List<Recurso> listaRecursos(int idHorario);
	public boolean guardarRecurso(Recurso recurso);
	public boolean actualizarCantidadMaterial(Material material, int cantidad);
	public boolean actualizarCantidadMaterial(Recurso recurso);
	public boolean eliminarRecurso(Recurso recurso);
}
