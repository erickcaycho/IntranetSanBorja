package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.AmbienteDao;
import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.AmbienteDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.EmpleadoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.service.CronogramaService;
import com.muni.sanborja.educacionculturaturismo.service.impl.CronogramaServiceImpl;

@ManagedBean(name = "cronogramaBean")
@SessionScoped
public class CronogramaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(CronogramaBean.class);

	private List<Cronograma> listaCronogramas;
	private Cronograma cronograma;
	CronogramaService cronogramaService = new CronogramaServiceImpl();
	private Horario selectedHorario;
	private int idEmpleado;
	private List<Empleado> listaEmpleados;

	@PostConstruct
	public void init() {
		cronograma = new Cronograma();
		cronograma.setEmpleado(new Empleado());
	}

	public void setListaCronogramas(List<Cronograma> listaCronogramas) {
		this.listaCronogramas = listaCronogramas;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public void remove(Cronograma cronograma) {
		//TODO
	}

	public List<Cronograma> getListaCronogramas() {
		log.info("::::::::::LISTA DE CRONOGRAMA ::::::::::");
		return listaCronogramas;
	}

	public void crearCronograma() {
		try {
			log.info(":::::::::::::::::::: horario para el crongorama  ");
			log.info(":::::::::::::::::::: horario para el crongorama  " + idEmpleado);
			cronograma.setHorario(selectedHorario);
			EmpleadoDao empleado= new EmpleadoDaoImpl();
			cronograma.setEmpleado(empleado.buscar(idEmpleado));
			String msg;
			if (cronogramaService.createCronograma(cronograma)) {
				msg = "Se creó correctamente la planificación";
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
		}
	}

	public Horario getSelectedHorario() {
		log.info(":::::::::set HORARIO EN CRONOGRAMA ::::::::::");
		return selectedHorario;
	}

	public void setSelectedHorario(Horario selectedHorario) {
		log.info(":::::::::Get HORARIO EN CRONOGRAMA ::::::::::");
		this.selectedHorario = selectedHorario;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public List<Empleado> getListaEmpleados() {
		this.listaEmpleados = new ArrayList<Empleado>();
		EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
		
		listaEmpleados = empleadoDao.listarEmpleado();
		
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
}
