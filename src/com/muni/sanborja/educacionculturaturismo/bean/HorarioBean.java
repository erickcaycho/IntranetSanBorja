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
import com.muni.sanborja.educacionculturaturismo.dao.SedeDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.AmbienteDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.HorarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.SedeDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "horarioBean")
@SessionScoped
public class HorarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(HorarioBean.class);
	
	private List<Horario> listaHorario;
	private Horario horario = new Horario();
	private Planificacion planificacion = new Planificacion();
	private Date todayDate = new Date();
	private int idambiente;
	private boolean ver;
	private List<SelectItem> listaSede;
	private List<SelectItem> listaAmbiente;
	
	private Horario selectedHorario;
	
	private Sede sede;
	private int idsede;

	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	PlanificacionActividadBean planificacionBean = application.evaluateExpressionGet(context, "#{planificacionActividadBean}", PlanificacionActividadBean.class);
	

	@PostConstruct
	public void init() {
		horario = new Horario();
		planificacion = new Planificacion();
		horario.setPlanificacion(new Planificacion());
		horario.setAmbiente(new Ambiente());
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

/** */
 	public Horario getSelectedHorario() {
		return selectedHorario;
	}

	public void setSelectedHorario(Horario selectedHorario) {
		this.selectedHorario = selectedHorario;
	}
 

	public int getIdambiente() {
		return idambiente;
	}

	public void setIdambiente(int idambiente) {
		this.idambiente = idambiente;
	}

	public boolean isVer() {
		return ver;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public PlanificacionActividadBean getPlanificacionBean() {
		return planificacionBean;
	}

	public void setPlanificacionBean(PlanificacionActividadBean planificacionBean) {
		this.planificacionBean = planificacionBean;
	}

	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
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
			log.info("CrearHorario Planificacion[] Inicio ");
			
			String msg;
			
			log.info(horario.getFechaInicio());
			log.info(horario.getFechaFin());
			
			log.info(horario.getEdadMin());
			log.info(horario.getEdadMax());
			
			
			
				if(horario.getFechaFin().before(horario.getFechaInicio())){
					
					msg ="Fecha fin no puede ser menor a la fecha inicio";
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
					FacesContext.getCurrentInstance().addMessage(null, message);
					
				}else if(horario.getEdadMin() > horario.getEdadMax()){
					
					msg ="La edad mínima no debe ser mayor a la edad máxima";
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
					FacesContext.getCurrentInstance().addMessage(null, message);
					
				}else{
					
					log.info("Capturado ID Planificacion: " + planificacionBean.getPlanificacion().getIdPlanificacion());
					
					horario.getPlanificacion().setIdPlanificacion(planificacionBean.getPlanificacion().getIdPlanificacion());
					horario.getAmbiente().getIdAmbiente();
					
					HorarioDao horarioDao = new HorarioDaoImpl();
					horarioDao.createHorario(horario);
					
					msg ="Se creó correctamente el Horario";
					
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
					FacesContext.getCurrentInstance().addMessage(null, message);

				}
		}
		
		catch (Exception e) {
		log.error("Error:" + e.getMessage());
		log.error(e.getStackTrace());
		}
	}
	
	public void reset(){
		log.info("Intentando resetear valores");
		RequestContext.getCurrentInstance().reset("form:panel");
		
	}
	
	public List<Horario> getListaHorario() {
		HorarioDao horarioDao = new HorarioDaoImpl();
		listaHorario = horarioDao.listarHorario(planificacionBean.getSelectedPlan().getIdPlanificacion());
		
		return listaHorario;
	}
		
	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}


	
 	public void crearRecursoPrueba(){

		log.info("INICIA CON LA ASIGNACIÓN DE HORARIO  .....");
		log.info("Captura id_Planificacion: " +selectedHorario.getIdHorario());
	
		log.info("obtener nombre de actividad: " + selectedHorario.getCantsesion());				
		
	}
 
}
