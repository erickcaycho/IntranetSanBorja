package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.service.EmpleadoService;
import com.muni.sanborja.educacionculturaturismo.service.impl.EmpleadoServiceImpl;

@ManagedBean(name = "empleadoBean")
@SessionScoped
public class EmpleadoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(EmpleadoBean.class);
	
	
	
	private List<SelectItem> listaEmpleados;
	private List<SelectItem> listaEmpleadosByRol;
	//private List<Empleado> listaEncargados;
	private Empleado empleado;
	private int idrol;
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
	

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public List<SelectItem> getListaEmpleadosByRol() {
		log.info("Codigo capturado----------------> = " + idrol);
		this.listaEmpleadosByRol = empleadoService.listarEmpleadoByRol(idrol);
		return listaEmpleadosByRol;
	}

	public void setListaEmpleadosByRol(List<SelectItem> listaEmpleadosByRol) {
		this.listaEmpleadosByRol = listaEmpleadosByRol;
	}

/*
	public List<Empleado> getListaEncargados() {
		Empleado emp = new Empleado();
		empleado.setIdEmpleado(2);
		listaEncargados.add(emp);
		return listaEncargados;
	}

	public void setListaEncargados(List<Empleado> listaEncargados) {
		this.listaEncargados = listaEncargados;
	}*/

	
	public void asignarEncargados() {

		log.info("asignarEncargados-------------> = " );
		/*try {
			String msg;
			if (empleadoService.asignarEncargados(empleado)) {
				msg = "Se asigno Encargado Correctamente";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, msg, null);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.info("Creado correctamente");

			} else {
				msg = "Ha ocurrido un inconveniente con la creación de la planificación. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, msg, null);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.error("Error al crear");
			}

		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}*/
	}
	
}
