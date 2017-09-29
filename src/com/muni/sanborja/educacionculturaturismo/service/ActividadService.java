package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import javax.faces.model.SelectItem;

public interface ActividadService {

	public List<SelectItem>listarActividad(int idtipoactividad);
	
}
