package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.TipoActividadDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.TipoActividadDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.TipoActividad;
import com.muni.sanborja.educacionculturaturismo.service.TipoActividadService;

public class TipoActividadServiceImpl implements TipoActividadService, Serializable {

	public static Logger log = Logger.getLogger(TipoActividadServiceImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	private TipoActividadDao tipoActividadDao = new TipoActividadDaoImpl();	
	@Override
	public List<SelectItem> listarTipoActividad() {
		List<SelectItem> listaTipoActividades = new ArrayList<SelectItem>();
		List<TipoActividad> t = tipoActividadDao .listarTipoActividad();
				
		for(TipoActividad tipoActividad : t){
			SelectItem tipoActividadItem = new SelectItem(tipoActividad.getIdTipoActividad(),tipoActividad.getNomTipoActividad());
			listaTipoActividades.add(tipoActividadItem);
		}
		
		return listaTipoActividades;
	}

}
