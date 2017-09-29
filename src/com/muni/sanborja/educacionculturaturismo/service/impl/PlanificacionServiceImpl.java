package com.muni.sanborja.educacionculturaturismo.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.dao.impl.PlanificacionDaoImpl;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;
import com.muni.sanborja.educacionculturaturismo.service.PlanificacionService;

public class PlanificacionServiceImpl implements PlanificacionService, Serializable {

	public static Logger log = Logger.getLogger(PlanificacionServiceImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	private PlanificacionDao planificacionDao = new PlanificacionDaoImpl();
	
	@Override
	public boolean create(Planificacion planificacion) {		
		return planificacionDao.create(planificacion);
	}

	@Override
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad(int idperiodo, int estado) {		
		return planificacionDao.listarPlanificacionPeriodoActividad(idperiodo, estado);
	}

	@Override
	public boolean validarActividadPorPeriodo(int idPeriodo, int idTipoActividad, int idActividad) {
		return planificacionDao.validarActividadPorPeriodo(idPeriodo, idTipoActividad, idActividad);
	}

	public boolean delete(Planificacion planificacion) {		
		return planificacionDao.delete(planificacion);
	}
	
	 public Planificacion buscar(int idPlanificacion) {
	        return planificacionDao.buscar(idPlanificacion); 
	    }

}
