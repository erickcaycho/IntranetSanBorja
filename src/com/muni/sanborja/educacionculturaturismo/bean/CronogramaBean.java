package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.CronogramaDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.CronogramaDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;

@ManagedBean(name = "cronogramaBean")
@SessionScoped
public class CronogramaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(PlanificacionActividadBean.class);

	private List<Cronograma> listaCronogramas;
	private Cronograma cronograma ;

	@PostConstruct
	public void init() {
		cronograma = new Cronograma();
	    cronograma.setEmpleado(new Empleado());
	    
	}

	
	public List<Cronograma> getListaCronogramas() {
		
		CronogramaDao cronogramaDao = new CronogramaDaoImpl();
				
		//listaCronogramas = cronogramaDao.listarCronograma(cronograma.getIdHorario(), cronograma.getIdCronograma());
		listaCronogramas = cronogramaDao.listarCronograma(2,1);
		
		
		return listaCronogramas;
	}
	


	public void crearCronograma(){
		try {
			CronogramaDao cronogramaDao = new CronogramaDaoImpl();
			
			String msg;
			if(cronogramaDao.createCronograma(cronograma)){
				msg ="Se creó correctamente la planificación";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.info("Creado correctamente");
				
				
			}else{
				msg ="Ha ocurrido un inconveniente con la creación de la planificación. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.error("Error al crear");
			}
			
			
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
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
	
	
	
	
	

}
