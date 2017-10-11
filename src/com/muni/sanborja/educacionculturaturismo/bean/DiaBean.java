package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import org.primefaces.extensions.event.BeforeShowEvent;
import org.primefaces.extensions.event.CloseEvent;
import org.primefaces.extensions.event.TimeSelectEvent;

import com.muni.sanborja.educacionculturaturismo.modelo.Dia;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.service.DiaService;
import com.muni.sanborja.educacionculturaturismo.service.impl.DiaServiceImpl;

@ManagedBean(name = "diaBean")
@SessionScoped
public class DiaBean implements Serializable{

	public static Logger log = Logger.getLogger(DiaBean.class);
	private static final long serialVersionUID = 1L;
	
	private Dia dia, diaSelected;
	private Date horaInicio;
	private Date horaFin;
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



	public Date getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
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
				DateFormat df = new SimpleDateFormat("HH:mm");
				dia.setHoraInicio(df.format(horaInicio));
				dia.setHoraFin(df.format(horaFin));
				dia.setHorario(horarioBean.getSelectedHorario());
				
				log.info("idHorario: " +dia.getHorario().getIdHorario());
				log.info("getHoraInicio: " +dia.getHoraInicio());
				log.info("getHoraFin: " +dia.getHoraFin());
				log.info("getDia: " +dia.getDia());
				
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
								FacesMessage.SEVERITY_ERROR, "No se ha seleccionado un horario", msg));
				log.error("Error al obtener horario");
			}
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
	
	
	   public void timeSelectListener(TimeSelectEvent timeSelectEvent) {  
			log.info("timeSelectListener");
	      FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Time select fired",  
	               "Selected time: " + getFormattedTime(timeSelectEvent.getTime(), "HH:mm"));  
	      FacesContext.getCurrentInstance().addMessage(null, msg);  
	      

			

	      Calendar calendar = Calendar.getInstance();  
	      
	      calendar.set(Calendar.HOUR, 11);  
	      calendar.set(Calendar.MINUTE, 40);  
	      //calendar.add(Calendar.HOUR, horarioBean.getSelectedHorario().getHorassesion()); 
	      horaFin = calendar.getTime();  
	      
	      
	   }  
	  
	   public void beforeShowListener(BeforeShowEvent beforeShowEvent) {  
			log.info("beforeShowListener");
	      /*FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Before show fired",  
	               "Component id: " + beforeShowEvent.getComponent().getId());  
	      FacesContext.getCurrentInstance().addMessage(null, msg);  */
	   }  
	  
	   public void closeListener(CloseEvent closeEvent) {  
			log.info("closeListener");
			
	      Calendar calendar = Calendar.getInstance();  
	      calendar.setTime(horaInicio);
	      /*calendar.set(Calendar.HOUR, 11);  
	      calendar.set(Calendar.MINUTE, 40);  */
	      calendar.add(Calendar.HOUR, horarioBean.getSelectedHorario().getHorassesion()); 
	      horaFin = calendar.getTime();  
	      RequestContext.getCurrentInstance().update(":frmDias:timeHoraFin");

	   }  
	  
	   private String getFormattedTime(Date time, String format) {  
			log.info("getFormattedTime");
	      if (time == null) {  
	         return null;  
	      }  
	  
	      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);  
	  
	      return simpleDateFormat.format(time);  
	   }

	   public void eliminarDia(Dia dia) {
		String msg;
		
		if(diaService.eliminarRecurso(dia.getIdDia())) {
			dias.remove(dia);

			msg = "Se eliminó correctamente el dia";
			RequestContext.getCurrentInstance()
							.showMessageInDialog(new FacesMessage(
							FacesMessage.SEVERITY_INFO, "Eliminar Dia", msg));
			log.info("Eliminado correctamente");
		}
	}
	
	
}
