package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.EmpleadoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.service.EmpleadoService;

public class EmpleadoServiceImpl implements Serializable, EmpleadoService {

	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(EmpleadoServiceImpl.class);
	
	private EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
	
	@Override
	public List<SelectItem> listarEmpleado() {
		
		List<SelectItem>  listaEmpleados = new ArrayList<SelectItem>();
		List<Empleado> e = empleadoDao.listarEmpleado();
		
		for (Empleado empleado : e) {
			SelectItem empleadoItem = new SelectItem(empleado.getIdEmpleado(),
					empleado.getNombre());
			listaEmpleados.add(empleadoItem);
		}
		return listaEmpleados;
	}

	
	@Override
	public List<Empleado> listarEmpleadoByRol(int idrol) {
		
		List<Empleado> lstempleado = empleadoDao.listarEmpleadoByRol(idrol);
		
		
		return lstempleado;
	}


	@Override
	public boolean asignarEncargados(Horario horario,  List<Empleado> lstEmpleado) {
		// TODO Auto-generated method stub
		return empleadoDao.asignarEncargados(horario,lstEmpleado);
	}


	@Override
	public List listarEncargados(int idHorario) {
		// TODO Auto-generated method stub
		return empleadoDao.listarEncargados(idHorario);
	}

}
