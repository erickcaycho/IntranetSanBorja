package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.AmbienteDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class AmbienteDaoImpl implements Serializable,AmbienteDao {

	public static Logger log = Logger.getLogger(AmbienteDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ambiente> listarAmbiente(int idSede) {
		List<Ambiente> listaAmbiente = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Ambiente WHERE idsede = :idsede ";
		
		try {
			log.info("Cod Sede " + idSede);
			
			listaAmbiente = session.createQuery(hql).setParameter("idsede",idSede ).list();
			
			if (listaAmbiente == null) {
				log.info("No hay Actividades");
				
			} else {
				log.info("[Ambiente] Se encontro " + listaAmbiente.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return listaAmbiente;
	}

}
