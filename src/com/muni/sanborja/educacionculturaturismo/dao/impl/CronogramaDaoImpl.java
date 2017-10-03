package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.muni.sanborja.educacionculturaturismo.dao.CronogramaDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class CronogramaDaoImpl implements Serializable,CronogramaDao{
	
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(CronogramaDaoImpl.class);

	@Override
	public boolean createCronograma(Cronograma cronograma) {
		boolean flag = false;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			if(cronograma == null) {
				log.info("cronograma es null");
			}else {
				session.save(cronograma);
				session.beginTransaction().commit();
				log.info("Guardado correctamente");
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
	
	@Override
	public boolean delete(Cronograma cronograma) {

		
		log.info("---ELIMINAR CRONOGRAMA SELECCIONADO---");
		log.info("Captura id_Cronograma: " +cronograma.getIdCronograma());
		
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.delete(cronograma);
			session.beginTransaction().commit();
			log.info("Eliminado correctamente");
			session.close();
			
			flag=true;
			
		} catch (Exception e) {
			flag=false;
			session.beginTransaction().rollback();
			
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		return flag;
	}
	
	@Override
	public List<Cronograma> listarCronograma(int idHorario) {
		List<Cronograma> listaCronograma = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		log.info("Listar Horario "+ idHorario);
		
		try {
			
			listaCronograma = session.createSQLQuery("FROM Cronograma  WHERE idHorario = :idHorario").
					setParameter("idHorario",idHorario).list();
			if(listaCronograma == null) {
				log.info("Data not found");
			}else {
				log.info("Tareas de Cronograma "+listaCronograma.size());
			}
			ts.commit();
			session.close();
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return listaCronograma;
	}
	
}
