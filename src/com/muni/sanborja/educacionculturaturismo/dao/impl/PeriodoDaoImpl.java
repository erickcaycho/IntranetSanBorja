package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Session;
//import org.hibernate.Query;

import com.muni.sanborja.educacionculturaturismo.dao.PeriodoDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class PeriodoDaoImpl implements Serializable,PeriodoDao{

	public static Logger log = Logger.getLogger(PeriodoDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Periodo> listarPeriodo() {
		
		List<Periodo> listaDePeriodos = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Periodo";
		
		try {
			
			listaDePeriodos  =session.createQuery(hql).list();
			
			if (listaDePeriodos == null) {
				log.info("No hay Periodo");
				
			} else {
				log.info("Se encontro " + listaDePeriodos.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
		}
		
		
		return listaDePeriodos;
	}

}
