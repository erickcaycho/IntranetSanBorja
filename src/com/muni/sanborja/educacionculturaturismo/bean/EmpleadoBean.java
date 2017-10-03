package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
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
	
	

	private int idrol;
	private int idempleado;
	private List<SelectItem> listaEmpleados;
	private List<Empleado> listaEmpleadosByRol;
	//private List<Empleado> listaEncargados;
	private Empleado empleado;


	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	HorarioBean horarioBean = application.evaluateExpressionGet(context,"#{horarioBean}", HorarioBean.class);
	
	
	
	EmpleadoService empleadoService = new EmpleadoServiceImpl();


	@PostConstruct
	public void init() {
		empleado = new Empleado();
	}
	
	public HorarioBean getHorarioBean() {
		return horarioBean;
	}

	public void setHorarioBean(HorarioBean horarioBean) {
		this.horarioBean = horarioBean;
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


	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public List<Empleado> getListaEmpleadosByRol() {
		this.listaEmpleadosByRol = new ArrayList<Empleado>();
		
		if(idrol>0) {
			listaEmpleadosByRol.clear();
			listaEmpleadosByRol = empleadoService.listarEmpleadoByRol(idrol);
			
		}
			
		return listaEmpleadosByRol;
	}

	public void setListaEmpleadosByRol(List<Empleado> listaEmpleadosByRol) {
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
		log.info("entro -asignarEncargados------------> = " );
		log.info("asignarEncargados cod horario-------------> = " + horarioBean.getSelectedHorario().getIdHorario());
		
/*
		try {
			String msg;
			List<Horario> lstHorario = new ArrayList<Horario>();
			
			/*lstHorario.add(horarioBean.getSelectedHorario());--
			Horario ho = new Horario();
			ho.setIdHorario(2);
			lstHorario.add(ho);
			empleado.setIdEmpleado(idempleado);
			empleado.setHorarios(lstHorario);
			if (empleadoService.asignarEncargados(empleado)) {
				msg = "Se asigno Encargado Correctamente";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, msg, null);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.info("Creado correctamente");

			} else {
				msg = "Ha ocurrido un inconveniente con la asignacion de Encargados. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
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
