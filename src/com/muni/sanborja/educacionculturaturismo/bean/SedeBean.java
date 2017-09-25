package com.muni.sanborja.educacionculturaturismo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import com.muni.sanborja.educacionculturaturismo.dao.SedeDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.SedeDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;

@ManagedBean(name = "sedeBean")
@SessionScoped
public class SedeBean {

	private List<SelectItem> listaSede;
	private Sede sede;
	
	public SedeBean(){
		this.sede=new Sede();
	}

	public List<SelectItem> getListaSede() {
		this.listaSede = new ArrayList<SelectItem>();
		SedeDao sedeDao = new SedeDaoImpl();
		List<Sede> p = sedeDao.listarSede();
		listaSede.clear();
		
		for(Sede sede : p){
			SelectItem sedeItem = new SelectItem(sede.getIdSede(), sede.getNombreSede());
			this.listaSede.add(sedeItem);
		}
		
		return listaSede;
	}

	public void setListaSede(List<SelectItem> listaSede) {
		this.listaSede = listaSede;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	 
	
}
