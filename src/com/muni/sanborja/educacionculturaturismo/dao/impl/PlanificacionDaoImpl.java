package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.transform.Transformer;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

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
		List<PlanificacionPeriodoActividad> plan  = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("inicia");
			Query query = session.createSQLQuery("CALL obtenerPlanificacionXPeriodoXActividad()");
			log.info("0");
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
			
			log.info("Registros encontrados: "  + plan.size());
			
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		
		return plan;
	}

}
