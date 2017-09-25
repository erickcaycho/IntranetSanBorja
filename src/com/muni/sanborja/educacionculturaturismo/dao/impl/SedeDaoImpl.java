package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.muni.sanborja.educacionculturaturismo.dao.SedeDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Sede;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class SedeDaoImpl implements Serializable,SedeDao{

	public static Logger log = Logger.getLogger(SedeDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sede> listarSede() {
		
		List<Sede> listaSede = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Sede";
		
		try {
			
			listaSede  =session.createQuery(hql).list();
			
			if (listaSede == null) {
				log.info("Sin sede");
				
			} else {
				log.info("Se encontro " + listaSede.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
		}
		
		
		return listaSede;
	}

}
