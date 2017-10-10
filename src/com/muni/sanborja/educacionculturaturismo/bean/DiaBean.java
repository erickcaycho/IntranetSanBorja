package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.modelo.Dia;
import com.muni.sanborja.educacionculturaturismo.service.DiaService;
import com.muni.sanborja.educacionculturaturismo.service.impl.DiaServiceImpl;

@ManagedBean(name = "diaBean")
@SessionScoped
public class DiaBean implements Serializable{

	public static Logger log = Logger.getLogger(RecursoBean.class);
	private static final long serialVersionUID = 1L;
	
	private Dia dia, diaSelected;
	private List<Dia> dias = new ArrayList<Dia>();
	
	FacesContext context = FacesContext.getCurrentInstance();
	Application application = context.getApplication();
	HorarioBean horarioBean = application.evaluateExpressionGet(context,"#{horarioBean}", HorarioBean.class);
	
	private DiaService diaService = new DiaServiceImpl();

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
		return dias;
	}

	public void setDias(List<Dia> dias) {
		this.dias = dias;
	}
	
	public void validarHoraFin() {
		
	}

	public void asignarDia() {
		diaService.asignarDia(new Dia());
	}
}
