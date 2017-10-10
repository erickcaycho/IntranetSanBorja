package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.DiaDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.DiaDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Dia;
import com.muni.sanborja.educacionculturaturismo.service.DiaService;

public class DiaServiceImpl implements DiaService, Serializable{

	public static Logger log = Logger.getLogger(DiaServiceImpl.class);
	private static final long serialVersionUID = 1L;
	private DiaDao diaDao = new DiaDaoImpl();
	
	@Override
	public boolean asignarDia(Dia dia) {
		return diaDao.asignarDia(dia);
	}

}
