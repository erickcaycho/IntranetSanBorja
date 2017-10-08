package com.muni.sanborja.educacionculturaturismo.service;

import java.util.List;

import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;

public interface EmpleadoService {

	public List<SelectItem> listarEmpleado();
	public List<Empleado> listarEmpleadoByRol(int idrol);
	public boolean asignarEncargados(Horario horario, List<Empleado> lstEmpleado);
	@SuppressWarnings("rawtypes")
	public List listarEncargados(int idHorario);
}
