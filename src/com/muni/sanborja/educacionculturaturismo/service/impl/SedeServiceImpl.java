package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.SedeDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.SedeDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;
import com.muni.sanborja.educacionculturaturismo.service.SedeService;

public class SedeServiceImpl implements Serializable,SedeService{

	public static Logger log = Logger.getLogger(SedeServiceImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	private SedeDao sedeDao = new SedeDaoImpl();
	
	@Override
	public List<SelectItem> listarSede() {	

		List<SelectItem> listaSedes = new ArrayList<SelectItem>();
		List<Sede> s = sedeDao.listarSede();
		
		for(Sede sede : s){
			SelectItem sedeItem = new SelectItem(sede.getIdSede(), sede.getNombreSede());
			listaSedes.add(sedeItem);
		}
		
		return listaSedes;
	}

}
