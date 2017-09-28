package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.muni.sanborja.educacionculturaturismo.dao.AmbienteDao;
import com.muni.sanborja.educacionculturaturismo.dao.HorarioDao;
import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.dao.SedeDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.AmbienteDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.HorarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanificacionDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.SedeDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;

@ManagedBean(name = "horarioBean")
@SessionScoped
public class HorarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(HorarioBean.class);
	
	private List<Horario> listaHorario;
	private Horario horario,selectedHorario;
	private String msg;
	private Date todayDate = new Date();
	private int idambiente;
	
	private List<SelectItem> listaSede;
	private List<SelectItem> listaAmbiente;
	
	private Sede sede;
	private int idsede;

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

	public int getIdsede() {
		return idsede;
	}

	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}

	public List<SelectItem> getListaSede() {
		this.listaSede = new ArrayList<SelectItem>();
		SedeDao sedeDao = new SedeDaoImpl();
		List<Sede> p = sedeDao.listarSede();
		listaSede.clear();
		
		for(Sede sede : p){
			SelectItem sedeItem = new SelectItem(sede.getIdSede(), sede.getNombreSede());
			this.listaSede.add(sedeItem);
		}
		
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
		this.listaAmbiente = new ArrayList<SelectItem>();
		AmbienteDao ambienteDao = new AmbienteDaoImpl();
		
		log.info("Codigo capturado = " + idsede);
		
		List<Ambiente> a = ambienteDao.listarAmbiente(idsede);
		listaAmbiente.clear();
		
		for(Ambiente ambiente : a){
			SelectItem actividadItem = new SelectItem(ambiente.getIdAmbiente(), ambiente.getNomAmbiente());
			this.listaAmbiente.add(actividadItem);
		}
		
		return listaAmbiente;
	}

	public void setListaAmbiente(List<SelectItem> listaAmbiente) {
		this.listaAmbiente = listaAmbiente;
	}
	public void crearHorario(){
		try {
			Planificacion planificacion = new Planificacion();
			log.info("PLANIFICACION ****  "+planificacionBean.getSelectedPlan().getNomActividad()+ "  ID "+ planificacionBean.getSelectedPlan().getIdPlanificacion());
			//log.info("PLANIFICACION ****  "+planificacionBean.getPlanificacion().getActividad().getNomActividad());
			//horario.setPlanificacion(planificacionBean.getPlanificacion());
			PlanificacionDao plan = new PlanificacionDaoImpl();
			planificacion = plan.buscar(planificacionBean.getSelectedPlan().getIdPlanificacion());
			horario.setPlanificacion(planificacion);
			AmbienteDao a= new AmbienteDaoImpl();
			horario.setAmbiente(a.buscar(idambiente));
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

	public int getIdambiente() {
		return idambiente;
	}

	public void setIdambiente(int idambiente) {
		this.idambiente = idambiente;
	}

}
