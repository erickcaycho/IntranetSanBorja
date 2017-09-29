package com.muni.sanborja.educacionculturaturismo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.service.EmpleadoService;
import com.muni.sanborja.educacionculturaturismo.service.impl.EmpleadoServiceImpl;

@ManagedBean(name = "empleadoBean")
@SessionScoped
public class EmpleadoBean {

	private List<SelectItem> listaEmpleados;
	private Empleado empleado;
	EmpleadoService empleadoService = new EmpleadoServiceImpl();

	public void setListaEmpleados(List<SelectItem> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<SelectItem> getListaEmpleados() {
		this.listaEmpleados = empleadoService.listarEmpleado();
		return listaEmpleados;
	}

}
