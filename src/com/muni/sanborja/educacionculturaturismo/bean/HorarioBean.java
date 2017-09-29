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
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.HorarioPlanificacionActividad;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;
import com.muni.sanborja.educacionculturaturismo.service.AmbienteService;
import com.muni.sanborja.educacionculturaturismo.service.HorarioService;
import com.muni.sanborja.educacionculturaturismo.service.SedeService;
import com.muni.sanborja.educacionculturaturismo.service.impl.AmbienteServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.HorarioServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.SedeServiceImpl;

@ManagedBean(name = "horarioBean")
@SessionScoped
public class HorarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(HorarioBean.class);
	
	private List<Horario> listaHorario;
	private Horario horario,selectedHorario;
	private Planificacion planificacion = new Planificacion();
	private String msg;
	private Date todayDate = new Date();
	private int idambiente;
	
	private List<SelectItem> listaSede;
	private List<SelectItem> listaAmbiente;
	private List<HorarioPlanificacionActividad> listaHorario2;
	private HorarioPlanificacionActividad selectedHorario2;
	
	private Sede sede;
	private int idsede;

	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	PlanificacionActividadBean planificacionBean = application.evaluateExpressionGet(context, "#{planificacionActividadBean}", PlanificacionActividadBean.class);
	
	SedeService sedeService = new SedeServiceImpl();
	HorarioService horarioService = new HorarioServiceImpl();
	AmbienteService ambienteService = new AmbienteServiceImpl();
	
	@PostConstruct
	public void init() {
		horario = new Horario();
		planificacion = new Planificacion();
		horario.setPlanificacion(new Planificacion());
	}
	
	public Date getTodayDate() {
	    return todayDate;
	}

	public Planificacion getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(Planificacion planificacion) {
		this.planificacion = planificacion;
	}
	
	public int getIdsede() {
		return idsede;
	}

	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}

	public List<SelectItem> getListaSede() {
		this.listaSede = sedeService.listarSede();		
		return listaSede;
	}

	public void setListaSede(List<SelectItem> listaSede) {
		this.listaSede = listaSede;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	public List<SelectItem> getListaAmbiente() {		
		this.listaAmbiente = ambienteService.listarAmbiente(idsede);		
		return listaAmbiente;
	}

	public void setListaAmbiente(List<SelectItem> listaAmbiente) {
		this.listaAmbiente = listaAmbiente;
	}
	
	public List<HorarioPlanificacionActividad> getListaHorario2() {
		listaHorario2 = horarioService.listarHorarioPlanificacionActividad();
		return listaHorario2;
	}

	public void setListaHorario2(List<HorarioPlanificacionActividad> listaHorario2) {
		this.listaHorario2 = listaHorario2;
	}

	public HorarioPlanificacionActividad getSelectedHorario2() {
		return selectedHorario2;
	}

	public void setSelectedHorario2(HorarioPlanificacionActividad selectedHorario2) {
		this.selectedHorario2 = selectedHorario2;
	}

	public Horario getSelectedHorario() {
		return selectedHorario;
	}

	public void setSelectedHorario(Horario selectedHorario) {
		this.selectedHorario = selectedHorario;
	}

	public List<Horario> getListaHorario() {
		log.info("******************************** " + planificacionBean.getSelectedPlan().getIdPlanificacion());		
		listaHorario = horarioService.listarHorario(planificacionBean.getSelectedPlan().getIdPlanificacion());
		log.info("******************************** " + planificacionBean.getSelectedPlan().getIdPlanificacion());		
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

	public int getIdambiente() {
		return idambiente;
	}

	public void setIdambiente(int idambiente) {
		this.idambiente = idambiente;
	}
	
	public void crearHorario(){
		try {
			//Planificacion planificacion = new Planificacion();
			//log.info("PLANIFICACION ****  "+planificacionBean.getSelectedPlan().getNomActividad()+ "  ID "+ planificacionBean.getSelectedPlan().getIdPlanificacion());
			
			//PlanificacionDao plan = new PlanificacionDaoImpl();
			//planificacion = plan.buscar(planificacionBean.getSelectedPlan().getIdPlanificacion());
			//horario.setPlanificacion(planificacion);
			
			log.info("[] Capturado ID Planificacion: " + planificacionBean.getPlanificacion().getIdPlanificacion());
			horario.getPlanificacion().setIdPlanificacion(planificacionBean.getPlanificacion().getIdPlanificacion());
			
			horario.setAmbiente(ambienteService.buscar(idambiente));
			log.info("Creado correctamente" + horario.getVacantemax());
			
			horarioService.createHorario(horario);
			msg ="Se creó correctamente el Horario";
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		catch (Exception e) {
		log.error("Error:" + e.getMessage());
		log.error(e.getStackTrace());
		}
	}

}
