package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.HorarioDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.HorarioDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.service.HorarioService;

public class HorarioServiceImpl implements Serializable,HorarioService{
	
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(HorarioServiceImpl.class);
	private HorarioDao horarioDao = new HorarioDaoImpl();
	 
	@Override
	public boolean createHorario(Horario horario) {
		return horarioDao.createHorario(horario);
	}
	
	@Override
	public List<Horario> listarHorario(int idPlanificacion) {
		return horarioDao.listarHorario(idPlanificacion);
	}
	
}
