package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.CronogramaDao;
import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.dao.HorarioDao;
import com.muni.sanborja.educacionculturaturismo.dao.MotivoRechazoDao;
import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.dao.RecursoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.CronogramaDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.EmpleadoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.HorarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.MotivoRechazoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanificacionDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.RecursoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.MotivoRechazo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.TipoActividad;
import com.muni.sanborja.educacionculturaturismo.service.ActividadService;
import com.muni.sanborja.educacionculturaturismo.service.PeriodoService;
import com.muni.sanborja.educacionculturaturismo.service.PlanificacionService;
import com.muni.sanborja.educacionculturaturismo.service.TipoActividadService;
import com.muni.sanborja.educacionculturaturismo.service.impl.ActividadServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.PeriodoServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.PlanificacionServiceImpl;
import com.muni.sanborja.educacionculturaturismo.service.impl.TipoActividadServiceImpl;

import resources.Constants;

@ManagedBean(name = "aprobarPlanBean")
@SessionScoped 
public class AprobarPlanificacionActividadBean implements Serializable {
	
	public static Logger log = Logger.getLogger(AprobarPlanificacionActividadBean.class);
	private static final long serialVersionUID = 1L;
	
	private List<SelectItem> listaPeriodos;
	private List<SelectItem> listaTipoActividades;
	private List<SelectItem> listaActividades;
	private List<Planificacion> listaPlanificacion;
	private List<Horario> listaHorario;
	
	private TipoActividad tipoActividad;

	private Planificacion selectedPlan = new Planificacion();
	private List<MotivoRechazo> listaMotivo;
	
	public Planificacion getSelectedPlan() {
		return selectedPlan;
	}

	public void setSelectedPlan(Planificacion selectedPlan) {
		this.selectedPlan = selectedPlan;
	}

	private int idperiodo;
	private int idestado;

	private int idtipoactividad;
	private int idactividad;
	
	PlanificacionService planificacionService = new PlanificacionServiceImpl();
	ActividadService actividadService = new ActividadServiceImpl();
	TipoActividadService tipoActividadService = new TipoActividadServiceImpl();
	PeriodoService periodoService = new PeriodoServiceImpl();
		   
	@PostConstruct
	public void init() {
		selectedPlan = new Planificacion();  
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

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public List<Planificacion> getListaPlanificacion() {
		return listaPlanificacion;
	}

	public void setListaPlanificacion(List<Planificacion> listaPlanificacion) {
		this.listaPlanificacion = listaPlanificacion;
	}
	
	public void consultarPlan(){
		
		log.info("CONSULTAR PLAN PARA APROBACIÓN PERIODO " +idperiodo+" ESTADO " +idestado+" TIPO ACTIVIDAD " + idtipoactividad+" ACTIVIDAD " + idactividad);
		PlanificacionDao plan = new PlanificacionDaoImpl();
		listaPlanificacion = plan.listarPlanificacion(idperiodo, idestado, idtipoactividad, idactividad);
		
	}
	
	public String consultarDetallePlan(){
		log.info("Consultar Detalle Plan idPlanificacion: " +selectedPlan.getIdPlanificacion());
		//Buscar Horarios del Plan seleccionado
		
		HorarioDao horario = new HorarioDaoImpl();
		setListaHorario(horario.listarHorario(selectedPlan.getIdPlanificacion()));				
		
		/*CronogramaDao crono= new CronogramaDaoImpl();
		crono.listarCronograma(   idHorario);
		
		RecursoDao re = new RecursoDaoImpl();
		re.listarRecursos(idHorario);
		EmpleadoDao em= new  EmpleadoDaoImpl();
		em.listarEncargados(idHorario);*/
		
		return Constants.APROBAR_HORARIO_ACTIVIDAD_PAGE;
	}
	
	public void aprobar(){
		 				
		 
	}
	public void desaprobar(){
			
		 
	}
	
	public List<Horario> getListaHorario() {
		return listaHorario;
	}

	public void setListaHorario(List<Horario> listaHorario) {
		this.listaHorario = listaHorario;
	}

	public List<MotivoRechazo> getListaMotivo() {
		MotivoRechazoDao mo = new MotivoRechazoDaoImpl();
		listaMotivo= mo.listarMotivoRechazo();
		return listaMotivo;
	}

	public void setListaMotivo(List<MotivoRechazo> listaMotivo) {

		this.listaMotivo = listaMotivo;
	}
	
}
 