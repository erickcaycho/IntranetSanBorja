package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.ActividadDao;
import com.muni.sanborja.educacionculturaturismo.dao.PeriodoDao;
import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.dao.TipoActividadDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.ActividadDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PeriodoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanificacionDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.TipoActividadDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;
import com.muni.sanborja.educacionculturaturismo.modelo.TipoActividad;

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
	
	private int idperiodo;
	private int idtipoactividad;
	private int idactividad;
	private int estado;
	
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

	public List<SelectItem> getListaPeriodos() {
		this.listaPeriodos = new ArrayList<SelectItem>();
		PeriodoDao periodoDao = new PeriodoDaoImpl();
		List<Periodo> p = periodoDao.listarPeriodo();
		listaPeriodos.clear();
		
		for(Periodo periodo : p){
			SelectItem periodoItem = new SelectItem(periodo.getIdPeriodo(), periodo.getNomPeriodo());
			this.listaPeriodos.add(periodoItem);
		}
		
		return listaPeriodos;
	}

	public void setListaPeriodos(List<SelectItem> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}
	
	public List<SelectItem> getListaTipoActividades() {
		this.listaTipoActividades = new ArrayList<SelectItem>();
		TipoActividadDao tipoActvidadDao = new TipoActividadDaoImpl();
		List<TipoActividad> t = tipoActvidadDao.listarTipoActividad();
		listaTipoActividades.clear();
		
		for(TipoActividad tipoActividad : t){
			SelectItem tipoActividadItem = new SelectItem(tipoActividad.getIdTipoActividad(),tipoActividad.getNomTipoActividad());
			this.listaTipoActividades.add(tipoActividadItem);
		}
		
		return listaTipoActividades;
	}
	public void setListaTipoActividades(List<SelectItem> listaTipoActividades) {
		this.listaTipoActividades = listaTipoActividades;
	}
	
	public List<SelectItem> getListaActividades() {
		this.listaActividades = new ArrayList<SelectItem>();
		ActividadDao actividadDao = new ActividadDaoImpl();
		
		log.info("Codigo capturado = " + idtipoactividad);
		
		List<Actividad> a = actividadDao.listarActividad(idtipoactividad);
		listaActividades.clear();
		
		for(Actividad actividad : a){
			SelectItem actividadItem = new SelectItem(actividad.getIdActividad(), actividad.getNomActividad());
			this.listaActividades.add(actividadItem);
		}
		
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
		
		PlanificacionDao planificacionDao = new PlanificacionDaoImpl();
				
		listaPlanificacion = planificacionDao.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());
		
		return listaPlanificacion;
	}

	public void setListaPlanificacion(List<PlanificacionPeriodoActividad> listaPlanificacion) {
		this.listaPlanificacion = listaPlanificacion;
	}

	public void crearPlanificacion(){
		try {
			
			Date date = new Date();
			planificacion.setFechaCreacion(new java.sql.Date(date.getTime()));
			planificacion.setEstado(1);
			
			PlanificacionDao planificacionDao = new PlanificacionDaoImpl();
			
			String msg;
			if(planificacionDao.create(planificacion)){
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
	
	
	
	public void consultarPlanificacion(){
		log.info("---CONSULTAR ---");
		log.info("idPeriodo_capturado: " +planificacion.getPeriodo().getIdPeriodo());
		log.info("Estado_capturado: " +planificacion.getEstado());
		
		PlanificacionDao planificacionDao = new PlanificacionDaoImpl();
		planificacionDao.listarPlanificacionPeriodoActividad(planificacion.getPeriodo().getIdPeriodo(),planificacion.getEstado());
		
		log.info("Tam actual: " + listaPlanificacion.size());
		
	}
	
}
