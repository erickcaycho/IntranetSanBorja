package com.muni.sanborja.educacionculturaturismo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.EmpleadoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;

@ManagedBean(name = "empleadoBean")
@SessionScoped
public class EmpleadoBean {
	
	private List<SelectItem> listaEmpleados;
	private Empleado empleado;
	
	
	
	public List<SelectItem> getListaEmpleados() {
		this.listaEmpleados = new ArrayList<SelectItem>();
		EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
		List<Empleado> e = empleadoDao.listarEmpleado();
		listaEmpleados.clear();
		
		for(Empleado empleado : e){
			SelectItem periodoItem = new SelectItem(empleado.getCodEmpleado(), empleado.getNombre());
			this.listaEmpleados.add(periodoItem);
		}
		
		return listaEmpleados;
	}
	public void setListaEmpleados(List<SelectItem> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}
