package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad(int idperiodo, int estado) {
		List<PlanificacionPeriodoActividad> plan  = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("inicia PlanificacionPeriodoActividad");
			Query query = session.createSQLQuery("CALL obtenerPlanificacionXPeriodoXActividad(:val_idperiodo,:val_estado)").setParameter("val_idperiodo", idperiodo).setParameter("val_estado", estado);
			List<Object[]> objs  = query.list();
			
			
			plan = new ArrayList<PlanificacionPeriodoActividad>();
			for (Object[] o : objs) {
				Object[] aux = o;
				PlanificacionPeriodoActividad p = new PlanificacionPeriodoActividad();
				
				p.setIdPlanificacion((Integer)aux[0]);
				p.setNomPeriodo((String)aux[1]);
				p.setFechaCreacion((Date)aux[2]);
				p.setFechaPlanificacion((Date)aux[3]);
				p.setFechaAprobacion((Date)aux[4]);
				p.setFechaRechazo((Date)aux[5]);
				p.setFechaAnulacion((Date)aux[6]);
				p.setFechaEjecucion((Date)aux[7]);
				p.setNomActividad((String)aux[8]);
				p.setNomTipoActividad((String)aux[9]);
				p.setEstado((String)aux[10]);
				
				plan.add(p);
			}
			
			log.info("Registros encontrados PlanificacionPeriodoActividad: "  + plan.size());
			
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return plan;
	}

	@Override
	public boolean validarActividadPorPeriodo(int idPeriodo, int idTipoActividad, int idActividad) {
		
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		SQLQuery query = null;
		
		try {
			query = session.createSQLQuery("CALL validarActividadPorPeriodo(:idperiodo, :idtipoactividad, :idactividad)");
			query.setParameter("idperiodo", idPeriodo);
			query.setParameter("idtipoactividad", idTipoActividad);
			query.setParameter("idactividad", idActividad);
			
			Object resultado = query.uniqueResult();
			
			int numResultado = Integer.parseInt(resultado.toString());
			
			if(numResultado == 0){
				flag=true;
			}else{
				flag=false;
			}
			
			log.info("Resultado de validarActividadPorPeriodo: " + resultado.toString() + "- Flag: "+ flag);
			
			
		} catch (Exception e) {
			log.error("Error Resultado de validarActividadPorPeriodo " +e.getMessage());
			  e.getMessage();
			  
			  flag=false;
		}
		
		return flag;
	}

	public boolean delete(Planificacion planificacion) {
		
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			if(planificacion == null)
				log.info("Id de Planificación is null");
			
			session.delete(planificacion);
			session.beginTransaction().commit();
			log.info("Eliminado correctamente");
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

}
