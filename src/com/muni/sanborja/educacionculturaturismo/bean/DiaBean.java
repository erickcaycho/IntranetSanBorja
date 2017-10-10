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

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.muni.sanborja.educacionculturaturismo.modelo.Dia;
import com.muni.sanborja.educacionculturaturismo.service.DiaService;
import com.muni.sanborja.educacionculturaturismo.service.impl.DiaServiceImpl;

@ManagedBean(name = "diaBean")
@SessionScoped
public class DiaBean implements Serializable{

	public static Logger log = Logger.getLogger(DiaBean.class);
	private static final long serialVersionUID = 1L;
	
	private Dia dia, diaSelected;
	private Date horaInicio;
	private List<Dia> dias = new ArrayList<Dia>();
	
	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	HorarioBean horarioBean = application.evaluateExpressionGet(context,"#{horarioBean}", HorarioBean.class);
	
	private DiaService diaService = new DiaServiceImpl();

	@PostConstruct
	public void init() {
		dia = new Dia();
		horaInicio = new Date();
	}
	
	
	
	public Date getHoraInicio() {
		return horaInicio;
	}



	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}



	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public Dia getDiaSelected() {
		return diaSelected;
	}

	public void setDiaSelected(Dia diaSelected) {
		this.diaSelected = diaSelected;
	}
	
	public List<Dia> getDias() {
		
		if(horarioBean.getSelectedHorario() != null) {
			dias = diaService.listaDias(horarioBean.getSelectedHorario().getIdHorario());
		}
		
		return dias;
	}

	public void setDias(List<Dia> dias) {
		this.dias = dias;
	}
	
	public void validarHoraFin() {
		
		log.info("Hora de Inicio: " + horaInicio);
	}

	public void asignarDia() {
		String msg;
		
		try {
			if(horarioBean.getSelectedHorario() != null) {
				dia.setHorario(horarioBean.getSelectedHorario()); 
				
				if (diaService.asignarDia(dia)) {
					dias.add(dia);

					msg = "Se creó añadió correctamente el día";
					RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Recurso creado", msg));

					log.info("Día creado correctamente");
					

				} else {
					msg = "Ha ocurrido un inconveniente con la creación del día. Si el problema persiste, reportar el error al siguiente correo: soporte.sanborja@munisanborja.edu.pe";
					RequestContext.getCurrentInstance()
									.showMessageInDialog(new FacesMessage(
									FacesMessage.SEVERITY_ERROR, "Error al crear Recurso", msg));
					log.error("Error al crear");
				}
			}else {
				msg = "No se ha seleccionado un horario";
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
}
