package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.MaterialDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class MaterialDaoImpl implements Serializable, MaterialDao{

	public static Logger log = Logger.getLogger(MaterialDaoImpl.class);
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> listarMateriales(String nombreMaterial) {
		List<Material> materiales = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String sql="FROM material WHERE nombre like '%:nombreMaterial%' ";
		
		try {
			log.info("nombre material " + nombreMaterial);
			
			materiales = session.createQuery(sql).setParameter("nombreMaterial",nombreMaterial).list();
			
			if (materiales == null) {
				log.info("No hay materiales asociados al nombre: " + nombreMaterial);
				
			} else {
				log.info("[Materiales] Se encontró " + materiales.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return materiales;
	}

}
