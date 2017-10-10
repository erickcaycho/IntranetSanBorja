package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import resources.Constants;

import com.muni.sanborja.educacionculturaturismo.dao.PlanPublicitarioDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanPublicitarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanPublicitario;
import com.muni.sanborja.educacionculturaturismo.service.PlanPublicitarioService;

public class PlanPublicitarioServiceImpl implements Serializable,PlanPublicitarioService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(PlanPublicitarioServiceImpl.class);
	private PlanPublicitarioDao planPubicitarioDao = new PlanPublicitarioDaoImpl();
	
	@Override
	public boolean createPlanPublicitario(PlanPublicitario planPublicitario) {

		File archivoOrigen = new File(Constants.RUTA_TEMPORAL + planPublicitario.getArchivoRuta());
		File archivoDestino = new File(Constants.RUTA_DESTINO + planPublicitario.getArchivoRuta());
		try {
			if(archivoDestino.exists()) archivoDestino.delete();
			FileUtils.moveFile(archivoOrigen, archivoDestino);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return planPubicitarioDao.createPlanPublicitario(planPublicitario);
	}

	@Override
	public PlanPublicitario obtener(int idPlanificacion) {
		return planPubicitarioDao.obtener(idPlanificacion);		
	}	
}
