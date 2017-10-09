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

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;

import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.EmpleadoDaoImpl;
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

	String infoCronograma="Información Cronograma";
	private List<Cronograma> listaCronogramas =null;
	private Cronograma cronograma;
	CronogramaService cronogramaService = new CronogramaServiceImpl();
	private Horario selectedHorario;
	private int idEmpleado;
	private List<Empleado> listaEmpleados;
	
	
	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	HorarioBean horarioBean = application.evaluateExpressionGet(context,"#{horarioBean}", HorarioBean.class);

	@PostConstruct
	public void init() {
		cronograma = new Cronograma();
		//cronograma.setEmpleado(new Empleado());
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
		if(listaCronogramas==null) {
			if(horarioBean.getSelectedHorario()!=null) {
				this.listaCronogramas = new ArrayList();
				listaCronogramas.clear();
				int idhorario = horarioBean.getSelectedHorario().getIdHorario();
				listaCronogramas = cronogramaService.listarCronograma(idhorario);
			
			}
		}
		
		
		return listaCronogramas;
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

	public HorarioBean getHorarioBean() {
		return horarioBean;
	}

	public void setHorarioBean(HorarioBean horarioBean) {
		this.horarioBean = horarioBean;
	}
	

	public void crearCronograma() {
		try {
			log.info(":::::::::::::::::::: horario para el crongorama  ");
			log.info(":::::::::::::::::::: horario para el crongorama  " + idEmpleado);
			cronograma.setHorario(horarioBean.getSelectedHorario());
			//EmpleadoDao empleado= new EmpleadoDaoImpl();
			//cronograma.setEmpleado(empleado.buscar(idEmpleado));
			Empleado emp= new Empleado();
			emp.setIdEmpleado(idEmpleado);
			cronograma.setEmpleado(emp);
			String msg;
			if (cronogramaService.createCronograma(cronograma)) {
				msg = "Tarea agregada al Cronograma";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_INFO, infoCronograma, msg);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.info("Tarea agregada al Cronograma");
				listaCronogramas=null;
			} else {
				msg = "No se pudo agregar la tarea. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
				FacesMessage message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR, infoCronograma, msg);
				FacesContext.getCurrentInstance().addMessage(null, message);

				log.error("Error al crear");
			}

		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	

	public void eliminarTarea(Cronograma crono) {

		log.info(" eliminarTarea()-------------------" );

		String msg;
		if(cronogramaService.delete(crono)) {
			msg = "Se elimino tarea correctamente";
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO, infoCronograma, msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
			log.info(" Se elimino()-------------------" );
			listaCronogramas=null;
		}else {
			msg = "No se pudo eliminar la tarea. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, infoCronograma, msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
			log.error("Error al eliminar Tarea-------------------" );
		}
		
	}


    public void onRowEdit(RowEditEvent event) {
		log.info(" onRowEdit()-------------------" );
		
		Cronograma objCrono = (Cronograma) event.getObject();
		
		String msg;
		if(cronogramaService.update(objCrono)) {
			msg = "Se actualizo tarea ";
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_INFO, infoCronograma, msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
			log.info(" Se elimino()-------------------" );
		}else {
			msg = "No se pudo actualizar la tarea. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, infoCronograma, msg);
			FacesContext.getCurrentInstance().addMessage(null, message);
			log.error("Error al actualizar Tarea-------------------" );
		}
		
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", String.valueOf(((Cronograma) event.getObject()).getIdCronograma()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
		log.info(" onCellEdit()-------------------" );
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

	

    
    public void ClearFields() {
		cronograma = new Cronograma();
		/*log.info(" reset()-------------------" );
        RequestContext.getCurrentInstance().reset("formCrono:panelCronograma");*/
    }

    public void Close() {
    	log.info(" Close()-------------------" );
    	ClearFields();
    }
    
    
    
}
