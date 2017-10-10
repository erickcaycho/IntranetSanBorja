package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import resources.Constants;
import resources.Util;

import com.muni.sanborja.educacionculturaturismo.modelo.PlanPublicitario;
import com.muni.sanborja.educacionculturaturismo.service.PlanPublicitarioService;
import com.muni.sanborja.educacionculturaturismo.service.impl.PlanPublicitarioServiceImpl;

@ManagedBean(name = "planPublicitarioBean")
@SessionScoped
public class PlanPublicitarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(PlanPublicitarioBean.class);
	
	private PlanPublicitario planPublicitario = new PlanPublicitario();
	private UploadedFile file;
	private String nuevoArchivo;  
	   
	PlanPublicitarioService planPublicitarioService = new PlanPublicitarioServiceImpl();

	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	PlanificacionActividadBean planificacionActividadBean = application.evaluateExpressionGet(context,"#{planificacionActividadBean}", PlanificacionActividadBean.class);
	
	@PostConstruct
	public void init() {
	}
	
	public PlanPublicitario getPlanPublicitario() {		
		planPublicitario = planPublicitarioService.obtener(planificacionActividadBean.getPlanificacion().getIdPlanificacion());
		return planPublicitario==null?new PlanPublicitario():planPublicitario;
	}
	
	public void setPlanPublicitario(PlanPublicitario planPublicitario) {
		this.planPublicitario = planPublicitario;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}	
	
	public String getNuevoArchivo() {
		nuevoArchivo = planPublicitario==null?"":planPublicitario.getArchivoRuta();
		nuevoArchivo = file==null?nuevoArchivo:file.getFileName();
		return nuevoArchivo;
	}

	public void setNuevoArchivo(String nuevoArchivo) {
		this.nuevoArchivo = nuevoArchivo;
	}

	public void crearPlanPublicitario(){
		try {	
			log.info("entro -crearPlanPublicitario------------> = " );
			log.info("crearPlanPublicitario id planificación-------------> = " + planificacionActividadBean.getPlanificacion().getIdPlanificacion());
			planPublicitario.setPlanificacion(planificacionActividadBean.getPlanificacion());
	        planPublicitario.setArchivoRuta(this.nuevoArchivo);
						
			String msg;
			if(planPublicitarioService.createPlanPublicitario(planPublicitario)){
				String accion = "creó";
				if(planPublicitario.getIdPlanPublicitario()!=0) accion  = "actualizó";
				msg ="Se " +accion + " correctamente el plan publicitario";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.info("Creado correctamente");
				
				
			}else{
				msg ="Ha ocurrido un inconveniente con la creación del plan publicitario. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				
				log.error("Error al crear");
			}
			
			
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	
	public void upload(FileUploadEvent event) {  
		
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getFile().getFileName() + " se ha cargado.", null);  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        this.file = event.getFile();
        this.nuevoArchivo = event.getFile().getFileName();
        
        try {
            Util.copyFile(event.getFile().getFileName(), event.getFile().getInputstream(),Constants.RUTA_TEMPORAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
		
	
}
