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
import org.primefaces.context.RequestContext;

import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;
import com.muni.sanborja.educacionculturaturismo.service.RecursoService;
import com.muni.sanborja.educacionculturaturismo.service.impl.RecursoServiceImpl;

@ManagedBean(name = "recursoBean")
@SessionScoped
public class RecursoBean implements Serializable {

	public static Logger log = Logger.getLogger(RecursoBean.class);
	private static final long serialVersionUID = 1L;

	private List<Material> listaMaterial;
	private List<Recurso> listaRecurso = new ArrayList<Recurso>();
	private Material material, selectedMaterial;
	private Recurso recurso, selectedRecurso;

	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	HorarioBean horarioBean = application.evaluateExpressionGet(context,"#{horarioBean}", HorarioBean.class);
	
	RecursoService recursoService = new RecursoServiceImpl();
	
	@PostConstruct
	public void init() {
		recurso = new Recurso();
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

	public Recurso getSelectedRecurso() {
		return selectedRecurso;
	}

	public void setSelectedRecurso(Recurso selectedRecurso) {
		this.selectedRecurso = selectedRecurso;
	}

	public void consultarMaterial() {
		listaMaterial = recursoService.listarMateriales(material.getNombre());
	}

	public void guardarRecurso() {
		String msg;
		
		try {
			
			
			if(selectedMaterial != null) {
				recurso.setMaterial(selectedMaterial);
				recurso.setHorario(horarioBean.getSelectedHorario());
				
				if(recurso.getCantidadUsar() > selectedMaterial.getCantidadDisponible() || 
						recurso.getCantidadUsar() == 0) {
					msg = "No se pueden aplicar la cantidad a usar ingresada";
					/*FacesMessage message = new FacesMessage(
							FacesMessage.SEVERITY_ERROR, msg, null);
					FacesContext.getCurrentInstance().addMessage(null, message);*/

					RequestContext.getCurrentInstance()
									.showMessageInDialog(new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Cantidad a usar inválida", msg));
					log.error("Error al crear recurso: Cantidad a usar inválida");
					return;
				}
				
				if (recursoService.guardarRecurso(recurso)) {

					listaRecurso.add(recurso);

					msg = "Se creó correctamente la planificación";
					FacesMessage message = new FacesMessage(
							FacesMessage.SEVERITY_INFO, msg, null);
					FacesContext.getCurrentInstance().addMessage(null, message);

					log.info("Creado correctamente");

				} else {
					msg = "Ha ocurrido un inconveniente con la creación de la planificación. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
					FacesMessage message = new FacesMessage(
							FacesMessage.SEVERITY_ERROR, msg, null);
					FacesContext.getCurrentInstance().addMessage(null, message);

					log.error("Error al crear");
				}
			}else {
				msg = "Debe seleccionar un material para agregar";
				RequestContext.getCurrentInstance()
								.showMessageInDialog(new FacesMessage(
								FacesMessage.SEVERITY_ERROR, "Seleccione material", msg));
				log.error("Error al crear recurso: Cantidad a usar es mayor a cantidad disponible");
			}

			

			log.info("Captura id_horario: " + recurso.getHorario().getIdHorario());
			log.info("Captura id_material: " + recurso.getMaterial().getIdMaterial());
			log.info("Captura cantidad usar: " + recurso.getCantidadUsar());

			// log.info(" CAPTURA REAL: " +
			// recursoDao.validarActividadPorPeriodo(planificacion.getPeriodo().getIdPeriodo(),
			// idtipoactividad, planificacion.getActividad().getIdActividad()));

			// if(recursoDao.validarActividadPorPeriodo(planificacion.getPeriodo().getIdPeriodo(),
			// idtipoactividad, planificacion.getActividad().getIdActividad())){

			

			/*
			 * }else{ msg ="Ya existe la actividad en el Periodo seleccionado";
			 * FacesMessage message = new
			 * FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
			 * FacesContext.getCurrentInstance().addMessage(null, message);
			 * 
			 * log.error("Error al crear"); }
			 */

		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}

}
