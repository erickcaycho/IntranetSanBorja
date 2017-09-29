package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;

public interface AmbienteService {

	public List<SelectItem>listarAmbiente(int idSede);
	public Ambiente buscar(int idAmbiente);
}
