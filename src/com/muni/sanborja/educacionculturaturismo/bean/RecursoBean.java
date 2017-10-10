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
		if(horarioBean.getSelectedHorario() != null) {
			listaRecurso = recursoService.listaRecursos(horarioBean.getSelectedHorario().getIdHorario());
		}
		
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
		selectedMaterial = null;
		listaMaterial = recursoService.listarMateriales(material.getNombre());
	}

	public void guardarRecurso() {
		log.info("entro -asignarEncargados------------> = " );
		log.info("asignarEncargados cod horario-------------> = " + horarioBean.getSelectedHorario().getIdHorario());
		String msg;
		int diferenciaCantidad;
		
		try {
			if(selectedMaterial != null) {
				recurso.setMaterial(selectedMaterial);
				recurso.setHorario(horarioBean.getSelectedHorario()); 
				
				if(recurso.getCantidadUsar() > selectedMaterial.getCantidadDisponible() || 
						recurso.getCantidadUsar() == 0) {
					msg = "No se puede aplicar la cantidad a usar ingresada";

					RequestContext.getCurrentInstance()
									.showMessageInDialog(new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Cantidad a usar inválida", msg));
					
					RequestContext.getCurrentInstance().update("materialesContainer");
					log.error("Error al crear recurso: Cantidad a usar inválida");
					return;
				}
				
				for (Recurso recurso : listaRecurso) {
					if (recurso.getMaterial().getIdMaterial() == selectedMaterial.getIdMaterial()) {
						msg = "Ya se encuentra registrado un material con el mismo nombre";

						RequestContext.getCurrentInstance()
										.showMessageInDialog(new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Duplicidad de registro", msg));
						log.error("Ya se encuentra registrado un material con el mismo nombre");
						return;
					}
				}
				
				if (recursoService.guardarRecurso(recurso)) {
					listaRecurso.add(recurso);

					msg = "Se creó correctamente el recurso";
					RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Recurso creado", msg));

					log.info("Recurso creado correctamente");
					
					diferenciaCantidad = selectedMaterial.getCantidadDisponible() - recurso.getCantidadUsar();
					
					if (recursoService.actualizarCantidadMaterial(selectedMaterial, diferenciaCantidad)) {
						listaMaterial = recursoService.listarMateriales(material.getNombre());
						RequestContext.getCurrentInstance().update("materialesContainer");
						
						log.info("Material actualizado correctamente");
					}

				} else {
					msg = "Ha ocurrido un inconveniente con la creación del recurso. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
					RequestContext.getCurrentInstance()
									.showMessageInDialog(new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Error al crear Recurso", msg));
					log.error("Error al crear");
				}
			}else {
				msg = "Debe seleccionar un material para agregar";
				RequestContext.getCurrentInstance()
								.showMessageInDialog(new FacesMessage(
								FacesMessage.SEVERITY_ERROR, "Seleccione material", msg));
				log.error("Error al crear recurso: Cantidad a usar es mayor a cantidad disponible");
			}
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	
	public void eliminarRecurso(Recurso recurso) {
		String msg;
		
		if(recursoService.eliminarRecurso(recurso)) {
			listaRecurso.remove(recurso);

			msg = "Se eliminó correctamente el recurso";
			RequestContext.getCurrentInstance()
							.showMessageInDialog(new FacesMessage(
							FacesMessage.SEVERITY_INFO, "Eliminar Recurso", msg));
			log.info("Eliminado correctamente");

			if (recursoService.actualizarCantidadMaterial(recurso)) {
				listaMaterial = recursoService.listarMateriales(material.getNombre());
				RequestContext.getCurrentInstance().update("materialesContainer");
				log.info("Material actualizado correctamente");
			}
		}
		
	}

}
