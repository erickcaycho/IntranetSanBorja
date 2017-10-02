package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.EmpleadoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
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
	public List<SelectItem> listarEmpleadoByRol(int idrol) {
		
		List<SelectItem>  listaEmpleadosRol = new ArrayList<SelectItem>();
		if(idrol > 0){
			 List<Empleado> e = empleadoDao.listarEmpleadoByRol(idrol);
		
			for (Empleado empleado : e) {
				SelectItem periodoItem = new SelectItem(empleado.getIdEmpleado(),
						empleado.getNombre());
				listaEmpleadosRol.add(periodoItem);
			}
		}
		return listaEmpleadosRol;
	}


	@Override
	public boolean asignarEncargados(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoDao.asignarEncargados(empleado);
	}

}
