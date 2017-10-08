package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;

public interface EmpleadoDao {

	public List<Empleado> listarEmpleado();
	
	public Empleado buscar(int idEmpleado);
	
	public List<Empleado> listarEmpleadoByRol(int idrol);

	public boolean asignarEncargados(Horario horario, List<Empleado> lstEmpleado);

	@SuppressWarnings("rawtypes")
	public List listarEncargados(int idHorario);
}
