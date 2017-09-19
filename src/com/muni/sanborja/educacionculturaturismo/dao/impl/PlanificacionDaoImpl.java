package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class PlanificacionDaoImpl implements PlanificacionDao, Serializable {

	public static Logger log = Logger.getLogger(PlanificacionDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@Override
	public boolean create(Planificacion planificacion) {
		boolean flag;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			if(planificacion == null)
				log.info("Planificación is null");
			
			session.save(planificacion);
			session.beginTransaction().commit();
			log.info("Guardado correctamente");
			session.close();
			
			flag=true;
			
		} catch (Exception e) {
			flag=false;
			session.beginTransaction().rollback();
			
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad() {
		
		List<PlanificacionPeriodoActividad> listaPlanificacionActividadPeriodo = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("inicia");
			Query query = session.createSQLQuery("CALL obtenerPlanificacionXPeriodoXActividad()");
			log.info("0");
			listaPlanificacionActividadPeriodo = query.list();
			log.info("Registros encontrados: "  + listaPlanificacionActividadPeriodo.size());
			
			for(int i=0; i<listaPlanificacionActividadPeriodo.size(); i++){
				
				PlanificacionPeriodoActividad p = (PlanificacionPeriodoActividad)listaPlanificacionActividadPeriodo.get(i);
				
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		
		return listaPlanificacionActividadPeriodo;
	}

}
