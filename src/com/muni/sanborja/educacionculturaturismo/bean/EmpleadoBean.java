package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
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
	
	

	String infoAlert="Información Encargados";
	private int idrol;
	private int idempleado;
	private List<SelectItem> listaEmpleados;
	private List<Empleado> listaEmpleadosByRol;
	//private List<Empleado> listaEncargados;
	private Empleado empleado;
	private Empleado selectedEncargado;
	private List<Empleado> lstEncargados ;


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
	
	public List<Empleado> getLstEncargados() {
		this.lstEncargados = new ArrayList();
		if(horarioBean.getSelectedHorario()!=null) {
			lstEncargados.clear();
			int idhorario = horarioBean.getSelectedHorario().getIdHorario();
			
			List lstTemp = empleadoService.listarEncargados(idhorario);

			Empleado emp = new Empleado();
	        for (int j=0; j<lstTemp.size(); j++){
		        
				Object objeto = lstTemp.get(j);
				String[] datos =objeto.toString().replace("[", "").replace("]", "").split(",");
				
				emp = new Empleado();
				emp.setIdEmpleado(Integer.parseInt(datos[0]));
				emp.setNombre(datos[1]);
				emp.setNombreRol(datos[2]);
				lstEncargados.add(emp);
	        }
			
			//lstEncargados = empleadoService.listarEncargados(idhorario);
		}
		
		return lstEncargados;
	}

	public void setLstEncargados(List<Empleado> lstEncargados) {
		this.lstEncargados = lstEncargados;
	}

	
	public Empleado getSelectedEncargado() {
		return selectedEncargado;
	}

	public void setSelectedEncargado(Empleado selectedEncargado) {
		this.selectedEncargado = selectedEncargado;
	}

	public void asignarEncargados(String opc) {
		log.info("asignarEncargados-------opcion: "+ opc );
		int idhorario = horarioBean.getSelectedHorario().getIdHorario();
		Horario horario = horarioBean.getSelectedHorario();
		
		
		List<Empleado> lstEmp= new ArrayList<Empleado>();
		Empleado emp = new Empleado();
        for (int j=0; j<lstEncargados.size(); j++){
	        
			Empleado obj = (Empleado)lstEncargados.get(j);
			
			emp = new Empleado();
			emp.setIdEmpleado(obj.getIdEmpleado());
			lstEmp.add(emp);
        }
        if(idempleado>0 && opc.equals("")) {
			emp = new Empleado();
			emp.setIdEmpleado(idempleado);
			lstEmp.add(emp);
        }
			
			
			
		try {
			String msg;
			if (empleadoService.asignarEncargados(horario,lstEmp)) {
				msg = "Se asigno Encargado Correctamente";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, infoAlert, msg);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.info("Creado correctamente");

			} else {
				msg = "Empleado ya se encuentra asignado para este Horario";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, infoAlert, msg);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.error("Error al crear");
			}

		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	
	

	public void eliminarEncargado(Empleado em) {

		log.info(" eliminarEncargado()-------------------" );
		

		Empleado empleado = new Empleado();

        for (int j=0; j<lstEncargados.size(); j++){
        	empleado = lstEncargados.get(j);
        	if(empleado.getIdEmpleado() == em.getIdEmpleado()) {
        		lstEncargados.remove(j);
        	}
        }
		log.info(" Se elimino()-------------------" );
		asignarEncargados("D");
	}
	
}
