package com.muni.sanborja.educacionculturaturismo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.service.PeriodoService;
import com.muni.sanborja.educacionculturaturismo.service.impl.PeriodoServiceImpl;

@ManagedBean(name = "periodoBean")
@SessionScoped
public class PeriodoBean {

	private List<SelectItem> listaPeriodos;
	private Periodo periodo;
	PeriodoService periodoService = new PeriodoServiceImpl();

	public PeriodoBean() {
		this.periodo = new Periodo();
	}

	public void setListaPeriodos(List<SelectItem> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<SelectItem> getListaPeriodos() {
		this.listaPeriodos = periodoService.listarPeriodo();
		return listaPeriodos;
	}

}
