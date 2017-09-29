package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.ActividadDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.ActividadDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.service.ActividadService;

public class ActividadServiceImpl implements Serializable,ActividadService {

	public static Logger log = Logger.getLogger(ActividadServiceImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	private ActividadDao actividadDao = new ActividadDaoImpl();
	
	@Override
	public List<SelectItem> listarActividad(int idtipoactividad) {
		List<SelectItem> listaActividades = new ArrayList<SelectItem>();
		List<Actividad> a = actividadDao.listarActividad(idtipoactividad);
				
		for(Actividad actividad : a){
			SelectItem actividadItem = new SelectItem(actividad.getIdActividad(), actividad.getNomActividad());
			listaActividades.add(actividadItem);
		}
		return listaActividades;
	}

}
