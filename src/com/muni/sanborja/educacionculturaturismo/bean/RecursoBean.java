package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.RecursoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.RecursoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;

@ManagedBean(name = "recursoBean")
@SessionScoped
public class RecursoBean implements Serializable{

	public static Logger log = Logger.getLogger(RecursoBean.class);
	private static final long serialVersionUID = 1L;
	
	private List<Material> listaMaterial;
	private List<Recurso> listaRecurso = new ArrayList<Recurso>();
	private Material material, selectedMaterial;
	private Recurso recurso;

	@PostConstruct
	public void init() {
		material = new Material();
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}


	public Material getSelectedMaterial() {
		return selectedMaterial;
	}

	public void setSelectedMaterial(Material selectedMaterial) {
		this.selectedMaterial = selectedMaterial;
	}

	public List<Material> getListaMaterial() {
		return listaMaterial;
	}
	
	public void setListaMaterial(List<Material> listaMaterial) {
		this.listaMaterial = listaMaterial;
	}
	
	public List<Recurso> getListaRecurso() {
		return listaRecurso;
	}

	public void setListaRecurso(List<Recurso> listaRecurso) {
		this.listaRecurso = listaRecurso;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public void consultarMaterial() {
		RecursoDao recursoDao = new RecursoDaoImpl();
		
		listaMaterial = recursoDao.listarMateriales(material.getNombre());
	}
	
	public void guardarRecurso() {
		try {
			
			recurso.setMaterial(selectedMaterial);
			recurso.setCantidadUsar(recurso.getCantidadUsar());
			recurso.setHorario(new Horario());
			
			RecursoDao recursoDao = new RecursoDaoImpl();
			
			log.info("Captura id_horario: " +recurso.getHorario().getIdHorario());
			log.info("Captura id_material: " + recurso.getMaterial().getIdMaterial());
			log.info("Captura cantidad usar: " + recurso.getCantidadUsar());
			
			//log.info(" CAPTURA REAL: " + recursoDao.validarActividadPorPeriodo(planificacion.getPeriodo().getIdPeriodo(), idtipoactividad, planificacion.getActividad().getIdActividad()));
			
			String msg;
			
			//if(recursoDao.validarActividadPorPeriodo(planificacion.getPeriodo().getIdPeriodo(), idtipoactividad, planificacion.getActividad().getIdActividad())){
				
				if(recursoDao.guardarRecurso(recurso)){
					
					listaRecurso.add(recurso);
					
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
				
			/*}else{
				msg ="Ya existe la actividad en el Periodo seleccionado";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.error("Error al crear");
			}*/
			
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}

}
