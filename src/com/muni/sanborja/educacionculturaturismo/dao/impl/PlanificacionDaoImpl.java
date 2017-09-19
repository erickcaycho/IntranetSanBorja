package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.TipoActividad;
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
	public List<Planificacion> listarPlanificacionPeriodoActividad() {
		List<Planificacion> listaPlanificacionActividadPeriodo = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql=" CALL obtenerPlanificacionXPeriodoXActividad()";
		
		try {
			Query query = session.createSQLQuery(hql).addEntity(Planificacion.class);
			listaPlanificacionActividadPeriodo = query.list();
			
			if (listaPlanificacionActividadPeriodo == null) {
				log.info("No hay Planificacion x Periodo x Actividad");
				
			} else {
				log.info("Se encontro un error en " + listaPlanificacionActividadPeriodo.size());
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
