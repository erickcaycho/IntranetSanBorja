package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.CronogramaDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.CronogramaDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.service.CronogramaService;

public class CronogramaServiceImpl implements Serializable,CronogramaService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(CronogramaServiceImpl.class);
	private CronogramaDao cronogramaDao = new CronogramaDaoImpl();

	@Override
	public boolean createCronograma(Cronograma cronograma) {		
		return cronogramaDao.createCronograma(cronograma);
	}

	@Override
	public List<Cronograma> listarCronograma(int idHorario) {
		return cronogramaDao.listarCronograma(idHorario);
	}

	@Override
	public boolean delete(Cronograma cronograma) {
		return cronogramaDao.delete(cronograma);
	}

	@Override
	public boolean update(Cronograma cronograma) {
		// TODO Auto-generated method stub
		return cronogramaDao.update(cronograma);
	}
}
