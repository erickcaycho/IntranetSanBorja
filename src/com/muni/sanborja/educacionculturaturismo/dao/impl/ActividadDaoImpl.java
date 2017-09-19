package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.ActividadDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Actividad;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class ActividadDaoImpl implements Serializable,ActividadDao {

	public static Logger log = Logger.getLogger(ActividadDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Actividad> listarActividad(int idtipoactividad) {
		List<Actividad> listaActividades = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Actividad WHERE idtipoactividad = :idtipoactividad ";
		
		try {
			log.info("Cod Tipo Actividad " + idtipoactividad);
			
			listaActividades = session.createQuery(hql).setParameter("idtipoactividad",idtipoactividad ).list();
			
			if (listaActividades == null) {
				log.info("No hay Actividades");
				
			} else {
				log.info("[Actividades] Se encontro " + listaActividades.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return listaActividades;
	}

}
