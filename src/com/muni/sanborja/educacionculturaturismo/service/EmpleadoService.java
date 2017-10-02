package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;

public interface EmpleadoService {

	public List<SelectItem> listarEmpleado();
	public List<Empleado> listarEmpleadoByRol(int idrol);
	public boolean asignarEncargados(Empleado empleado);
}
