package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.muni.sanborja.educacionculturaturismo.dao.HorarioDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class HorarioDaoImpl implements Serializable,HorarioDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(HorarioDaoImpl.class);
	
	@Override
	public boolean createHorario(Horario horario) {
		boolean flag = false;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			if(horario == null)
				log.info("Horario es null");

				session.save(horario);
				session.beginTransaction().commit();
				log.info("Guardado correctamente");
				session.close();
				flag=true;

		} catch (Exception e) {
			flag=false;
			session.beginTransaction().rollback();
			session.close();
			
			log.error("error " +e.getMessage());
		    e.getMessage();
		}
		
		return flag;
	}
	
	@Override
	public List<Horario> listarHorario(int idPlanificacion) {
		List<Horario> listaHorario = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("Listar Horario "+idPlanificacion);
			listaHorario = session.createQuery("FROM Horario  WHERE idplanificacion = :idplanificacion").
				setParameter("idplanificacion",idPlanificacion).list();
			
			log.info("Registros encontrados Horario: "  + listaHorario.size());
			
			ts.commit();
			session.close();
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return listaHorario;
	}

	
	
}
