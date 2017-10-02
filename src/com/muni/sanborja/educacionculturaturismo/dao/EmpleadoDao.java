package com.muni.sanborja.educacionculturaturismo.dao;

import java.util.List;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;

public interface EmpleadoDao {

	public List<Empleado> listarEmpleado();

	public List<Empleado> listarEmpleadoByRol(int idrol);

	public boolean asignarEncargados(Empleado empleado);
}
