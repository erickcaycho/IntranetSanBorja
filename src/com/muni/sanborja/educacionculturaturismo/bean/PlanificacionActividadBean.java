package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import resources.Constants;
import resources.FechaUtil;

import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;
import com.muni.sanborja.educacionculturaturismo.modelo.TipoActividad;
import com.muni.sanborja.educacionculturaturismo.service.ActividadService;
import com.muni.sanborja.educacionculturaturismo.service.PeriodoService;
import com.muni.sanborja.educacionculturaturismo.service.PlanificacionService;
import com.muni.sanborja.educacionculturaturismo.service.SedeService;
import com.muni.sanborja.educacionculturaturismo.service.TipoActividadService;
import com.muni.sanborja.educacionculturaturismo.service.impl.ActividadServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.PeriodoServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.PlanificacionServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.SedeServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.TipoActividadServiceImpl;

@ManagedBean(name = "planificacionActividadBean")
@SessionScoped 
public class PlanificacionActividadBean implements Serializable {
	
	public static Logger log = Logger.getLogger(PlanificacionActividadBean.class);
	private static final long serialVersionUID = 1L;
	
	private List<SelectItem> listaPeriodos;
	private List<SelectItem> listaTipoActividades;
	private List<SelectItem> listaActividades;
	private List<PlanificacionPeriodoActividad> listaPlanificacion;
	
	private TipoActividad tipoActividad;

	private Planificacion planificacion = new Planificacion();
	private PlanificacionPeriodoActividad selectedPlan;
	
	private int idperiodo;
	private int idtipoactividad;
	private int idactividad;
	private int estado;
	private int idplanificacion;	
	private List<SelectItem> listaSedes;	
	SedeService sedeService = new SedeServiceImpl();
	PlanificacionService planificacionService = new PlanificacionServiceImpl();
	ActividadService actividadService = new ActividadServiceImpl();
	TipoActividadService tipoActividadService = new TipoActividadServiceImpl();
	PeriodoService periodoService = new PeriodoServiceImpl();
		   
	@PostConstruct
	public void init() {
	    planificacion = new Planificacion();
	    planificacion.setPeriodo(new Periodo());
	    planificacion.setActividad(new Actividad());	    
	}
	
	public int getIdactividad() {
		return idactividad;
	}

	public void setIdactividad(int idactividad) {
		this.idactividad = idactividad;
	}

	public int getIdperiodo() {
		return idperiodo;
	}

	public void setIdperiodo(int idperiodo) {
		this.idperiodo = idperiodo;
	}
	
	public int getIdtipoactividad() {
		return idtipoactividad;
	}

	public void setIdtipoactividad(int idtipoactividad) {
		this.idtipoactividad = idtipoactividad;
	}
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public PlanificacionPeriodoActividad getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(PlanificacionPeriodoActividad selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	public List<SelectItem> getListaPeriodos() {
		this.listaPeriodos = periodoService.listarPeriodo();
		return listaPeriodos;
	}

	public void setListaPeriodos(List<SelectItem> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}
	
	public List<SelectItem> getListaTipoActividades() {
		this.listaTipoActividades = tipoActividadService.listarTipoActividad();
		return listaTipoActividades;
	}
	public void setListaTipoActividades(List<SelectItem> listaTipoActividades) {
		this.listaTipoActividades = listaTipoActividades;
	}
	
	public List<SelectItem> getListaActividades() {		
		this.listaActividades = actividadService.listarActividad(idtipoactividad);		
		return listaActividades;
	}
	
	public void setListaActividades(List<SelectItem> listaActividades) {
		this.listaActividades = listaActividades;
	}
	
	public TipoActividad getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(TipoActividad tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
	public Planificacion getPlanificacion() {
		return planificacion;
	}

	public void setPlanificacion(Planificacion planificacion) {
		this.planificacion = planificacion;
	}

	public List<PlanificacionPeriodoActividad> getListaPlanificacion() {				
		listaPlanificacion = planificacionService.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());		
		return listaPlanificacion;
	}

	public void setListaPlanificacion(List<PlanificacionPeriodoActividad> listaPlanificacion) {
		this.listaPlanificacion = listaPlanificacion;
	}
	
	public List<SelectItem> getListaSedes() {		
		this.listaSedes = sedeService.listarSede();		
		return listaSedes;
	}

	public void setListaSedes(List<SelectItem> listaSedes) {
		this.listaSedes = listaSedes;
	}
	
	public void crearPlan(){
		try {
			
			planificacion.setFechaCreacion(new java.sql.Date(FechaUtil.ahora().getTime()));
			planificacion.setEstado(Constants.ESTADO_PENDIENTE);
			
			log.info("Captura id_actividad: " +planificacion.getActividad().getIdActividad());
			log.info("Captura id_tipoactividad: " + idtipoactividad);
			log.info("Captura id_periodo: " + planificacion.getPeriodo().getIdPeriodo());			
			log.info(" CAPTURA REAL: " + planificacionService.validarActividadPorPeriodo(planificacion.getPeriodo().getIdPeriodo(), idtipoactividad, planificacion.getActividad().getIdActividad()));
			
			String msg;
			
			if(planificacionService.validarActividadPorPeriodo(planificacion.getPeriodo().getIdPeriodo(), idtipoactividad, planificacion.getActividad().getIdActividad())){
				
				if(planificacionService.create(planificacion)){
					
					planificacionService.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());
					
					msg ="Se creó correctamente el plan de actividad";
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
					FacesContext.getCurrentInstance().addMessage(null, message);
					
					log.info("Creado correctamente");
					
				}else{
					msg ="Ha ocurrido un inconveniente con la creación del plan. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
					FacesContext.getCurrentInstance().addMessage(null, message);
					
					log.error("Error al crear");
				}
				
			}else{
				msg ="Ya existe la actividad en el Periodo seleccionado";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.error("Error al crear");
			}
			
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
		
	public void consultarPlan(){		
		planificacionService.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());		
	}
	
	public void eliminarPlan() {
		try {
			
			Planificacion objPlanificacion = new Planificacion();
			objPlanificacion.setIdPlanificacion(selectedPlan.getIdPlanificacion());			
	
			String msg;
				
			if(planificacionService.delete(objPlanificacion)){
				
				planificacionService.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());
				
				msg ="Se eliminó correctamente la planificación";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.info("Eliminiado correctamente");
				
			}else{
				msg ="Ha ocurrido un inconveniente con la eliminación de la planificación. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.error("Error al eliminar");
			}
			
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	
	public String planificarPlan(){
		
		log.info("INICIA CON LA ASIGNACIÓN DE PLANIFICACIÓN  .....");
		log.info("Captura id_Planificacion: " +selectedPlan.getIdPlanificacion());
		
		idplanificacion = selectedPlan.getIdPlanificacion();
		planificacion.setIdPlanificacion(selectedPlan.getIdPlanificacion());
		
		log.info("obtener nombre de actividad: " + selectedPlan.getNomActividad());				
		
		return Constants.PLANIFICAR_ACTIVIDAD_PAGE;
		
	}
	
	public void actualizarEstadoPlanificado() {
		try {
			Planificacion objPlanificacion = new Planificacion();
			objPlanificacion.setIdPlanificacion(selectedPlan.getIdPlanificacion());	
			objPlanificacion.setFechaPlanificacion(new java.sql.Date(FechaUtil.ahora().getTime()));
	
			String msg;
				
			if(planificacionService.updatePlanificacion(objPlanificacion)){
				
				planificacionService.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());
				
				msg ="Se guardó correctamente la planificación";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.info("Guardado correctamente");
				
			}else{
				msg ="Ha ocurrido un inconveniente con el guardado de la planificación. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.error("Error al guardar");
			}
			
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	
}
 