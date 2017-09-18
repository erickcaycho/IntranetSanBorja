package com.muni.sanborja.educacionculturaturismo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.dao.PeriodoDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PeriodoDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;

@ManagedBean(name = "periodoBean")
@SessionScoped
public class PeriodoBean {

	private List<SelectItem> listaPeriodos;
	private Periodo periodo;
	
	public PeriodoBean(){
		this.periodo=new Periodo();
	}

	public List<SelectItem> getListaPeriodos() {
		this.listaPeriodos = new ArrayList<SelectItem>();
		PeriodoDao periodoDao = new PeriodoDaoImpl();
		List<Periodo> p = periodoDao.listarPeriodo();
		listaPeriodos.clear();
		
		for(Periodo periodo : p){
			SelectItem periodoItem = new SelectItem(periodo.getIdPeriodo(), periodo.getNomPeriodo());
			this.listaPeriodos.add(periodoItem);
		}
		
		return listaPeriodos;
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
	
	 
	
}
