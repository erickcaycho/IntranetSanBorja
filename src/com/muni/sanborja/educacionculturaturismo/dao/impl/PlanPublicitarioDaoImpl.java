package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.muni.sanborja.educacionculturaturismo.dao.PlanPublicitarioDao;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanPublicitario;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class PlanPublicitarioDaoImpl implements Serializable,PlanPublicitarioDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(PlanPublicitarioDaoImpl.class);

	@Override
	public boolean createPlanPublicitario(PlanPublicitario planPublicitario) {
		boolean flag = false;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if(planPublicitario == null) {
				log.info("plan Publicitario es null");
			}else {
				if(planPublicitario.getIdPlanPublicitario()!=0){
					session.update(planPublicitario);
					session.beginTransaction().commit();
					log.info("Actualizado correctamente");
				}else{
					session.save(planPublicitario);
					session.beginTransaction().commit();
					log.info("Guardado correctamente");
				}				
				session.close();
				flag=true;
			}

			
		} catch (Exception e) {
			session.beginTransaction().rollback();
			
			log.error("error " +e.getMessage());
		    e.getMessage();
		}
		
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PlanPublicitario obtener(int idPlanificacion) {
			
		List<PlanPublicitario> liPlanPublicitarios = null;
		PlanPublicitario planPublicitario = null;
			
			Session session = HibernateSessionFactory.getSessionFactory().openSession();
			Transaction ts = session.beginTransaction();
			String hql="FROM PlanPublicitario  WHERE idPlanificacion = :idPlanificacion"; 
			
			try {
				log.info("Cod Planificación " + idPlanificacion);
				
				liPlanPublicitarios  = session.createQuery(hql).setParameter("idPlanificacion",idPlanificacion).list();
				
				if (liPlanPublicitarios == null || liPlanPublicitarios.size()==0) {
					log.info("No existe Plan Publicitario");
				} else {
					planPublicitario = liPlanPublicitarios.get(0);
					log.info("[Plan Publicitario] Se encontró el Plan Publicitario con Id:" + planPublicitario.getIdPlanPublicitario());
					
				}
				
				ts.commit();
				session.close();
				
			} catch (Exception e) {
				log.error("error " +e.getMessage());
				  e.getMessage();
			 
			}	
			
			return planPublicitario;
		
	}	
}
