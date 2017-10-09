package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.muni.sanborja.educacionculturaturismo.dao.MotivoRechazoDao;
import com.muni.sanborja.educacionculturaturismo.modelo.MotivoRechazo;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class MotivoRechazoDaoImpl implements Serializable,MotivoRechazoDao {

	public static Logger log = Logger.getLogger(MotivoRechazoDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@Override
	public List<MotivoRechazo> listarMotivoRechazo() {
		List<MotivoRechazo> listaMotivoRechazo = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM MotivoRechazo";
		
		try {
			
			listaMotivoRechazo = session.createQuery(hql).list();
			
			if (listaMotivoRechazo == null) {
				log.info("No hay Motivo de Rechazo");
				
			} else {
				log.info("[MotivoRechazo] Se encontro " + listaMotivoRechazo.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			session.close();
			log.error("error " +e.getMessage());
			e.getMessage();
		}
		
		return listaMotivoRechazo;
	}

	@Override
	public MotivoRechazo buscarMotivoRechazo(int idMotivoRechazo) {
		MotivoRechazo motivo = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
			
	       try {
	    	   motivo = (MotivoRechazo) session.get(MotivoRechazo.class, idMotivoRechazo); 
	    	   session.close();
	    	   
	        } catch (Exception e) {
				session.beginTransaction().rollback();
				session.close();
				log.error("error " +e.getMessage());
				  e.getMessage();
			}
	      return motivo; 
	}
}
