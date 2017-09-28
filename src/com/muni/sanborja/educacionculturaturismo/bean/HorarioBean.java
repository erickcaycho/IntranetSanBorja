package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.HorarioDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.HorarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;

@ManagedBean(name = "horarioBean")
@SessionScoped
public class HorarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(PlanificacionActividadBean.class);
	
	private List<Horario> listaHorario;
	private Horario horario,selectedHorario;
	private String msg;
	private Date todayDate = new Date();
	
	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	PlanificacionActividadBean planificacionBean = application.evaluateExpressionGet(context, "#{planificacionActividadBean}", PlanificacionActividadBean.class);
	
	@PostConstruct
	public void init() {
		horario = new Horario();
	}
	
	public Date getTodayDate() {
	    return todayDate;
	}
	
	public void crearHorario(){
		try {
			log.info("PLANIFICACION ****  "+planificacionBean.getSelectedPlan().getNomActividad()+ "  ID "+ planificacionBean.getSelectedPlan().getIdPlanificacion());
			//log.info("PLANIFICACION ****  "+planificacionBean.getPlanificacion().getActividad().getNomActividad());
			//horario.setPlanificacion(planificacionBean.getPlanificacion());
			log.info("Creado correctamente" + horario.getVacantemax());
			HorarioDao horarioDao = new HorarioDaoImpl();
			horarioDao.createHorario(horario);
			msg ="Se creó correctamente el Horario";
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch (Exception e) {
		log.error("Error:" + e.getMessage());
		log.error(e.getStackTrace());
	}
	}

	public Horario getSelectedHorario() {
		return selectedHorario;
	}

	public void setSelectedHorario(Horario selectedHorario) {
		this.selectedHorario = selectedHorario;
	}

	public List<Horario> getListaHorario() {
		return listaHorario;
	}

	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

}
