package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.RolDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Rol;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class RolDaoImpl implements Serializable,RolDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(RolDaoImpl.class);
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> listarRoles() {
		// TODO Auto-generated method stub
		List<Rol> listaRoles = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Rol";
		
		try {
			
			listaRoles  = session.createQuery(hql).list();
			
			if (listaRoles == null) {
				log.info("No hay Roles");
				
			} else {
				log.info("Se encontro " + listaRoles.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
		}
		
		
		return listaRoles;
	}

	
	
}
