package com.muni.sanborja.educacionculturaturismo.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.AmbienteDao;
import com.muni.sanborja.educacionculturaturismo.dao.SedeDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.AmbienteDaoImpl;
import com.muni.sanborja.educacionculturaturismo.dao.impl.SedeDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;

@ManagedBean(name = "sedeBean")
@SessionScoped
public class SedeBean implements Serializable {
	
	private static final long serialVersionUID = 3558653004795076773L;
	public static Logger log = Logger.getLogger(PlanificacionActividadBean.class);

	private List<SelectItem> listaSede;
	private List<SelectItem> listaAmbiente;
	
	private Sede sede;
	private int idsede;
	private int idambiente;
	
	
	public SedeBean(){
		this.sede=new Sede();
		
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public int getIdsede() {
		return idsede;
	}

	public void setIdsede(int idsede) {
		this.idsede = idsede;
	}

	public int getIdambiente() {
		return idambiente;
	}

	public void setIdambiente(int idambiente) {
		this.idambiente = idambiente;
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
	
	public List<SelectItem> getListaAmbiente() {
		this.listaAmbiente = new ArrayList<SelectItem>();
		AmbienteDao ambienteDao = new AmbienteDaoImpl();
		
		log.info("Codigo capturado = " + idsede);
		
		List<Ambiente> a = ambienteDao.listarAmbiente(idsede);
		listaAmbiente.clear();
		
		for(Ambiente ambiente : a){
			SelectItem actividadItem = new SelectItem(ambiente.getIdAmbiente(), ambiente.getNomAmbiente());
			this.listaAmbiente.add(actividadItem);
		}
		
		return listaAmbiente;
	}

	public void setListaAmbiente(List<SelectItem> listaAmbiente) {
		this.listaAmbiente = listaAmbiente;
	}
	
}
