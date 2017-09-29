package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.service.CronogramaService;
import com.muni.sanborja.educacionculturaturismo.service.impl.CronogramaServiceImpl;

@ManagedBean(name = "cronogramaBean")
@SessionScoped
public class CronogramaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Logger log = Logger.getLogger(CronogramaBean.class);

	private List<Cronograma> listaCronogramas;
	private Cronograma cronograma;
	CronogramaService cronogramaService = new CronogramaServiceImpl();

	@PostConstruct
	public void init() {
		cronograma = new Cronograma();
		cronograma.setEmpleado(new Empleado());
	}

	public void setListaCronogramas(List<Cronograma> listaCronogramas) {
		this.listaCronogramas = listaCronogramas;
	}

	public Cronograma getCronograma() {
		return cronograma;
	}

	public void setCronograma(Cronograma cronograma) {
		this.cronograma = cronograma;
	}

	public void remove(Cronograma cronograma) {
		//TODO
	}

	public List<Cronograma> getListaCronogramas() {
		// listaCronogramas = cronogramaDao.listarCronograma(cronograma.getIdHorario(), cronograma.getIdCronograma());
		listaCronogramas = cronogramaService.listarCronograma(2, 1);
		return listaCronogramas;
	}

	public void crearCronograma() {
		try {
			String msg;
			if (cronogramaService.createCronograma(cronograma)) {
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

		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			log.error(e.getStackTrace());
		}
	}
}
