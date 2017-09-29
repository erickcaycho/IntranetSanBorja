package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.TipoActividadDao;
import com.muni.sanborja.educacionculturaturismo.modelo.TipoActividad;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class TipoActividadDaoImpl implements TipoActividadDao, Serializable {

	public static Logger log = Logger.getLogger(TipoActividadDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoActividad> listarTipoActividad() {
		List<TipoActividad> listaTipoActividades = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM TipoActividad";
		
		try {
			listaTipoActividades = session.createQuery(hql).list();
			
			if (listaTipoActividades == null) {
				log.info("No hay Tipo de Actividades");
				
			} else {
				log.info("Se encontro " + listaTipoActividades.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return listaTipoActividades;
	}

}
