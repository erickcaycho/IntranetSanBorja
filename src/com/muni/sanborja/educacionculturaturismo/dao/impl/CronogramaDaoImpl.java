package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.muni.sanborja.educacionculturaturismo.dao.CronogramaDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Cronograma;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class CronogramaDaoImpl implements Serializable,CronogramaDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(PeriodoDaoImpl.class);

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


	@SuppressWarnings("unchecked")
	@Override
	public List<Cronograma> listarCronograma(int idHorario,int idCronograma) {
		// TODO Auto-generated method stub
		
		List<Cronograma> listaCronograma = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		
		String hql="FROM Cronograma  WHERE idHorario = :idHorario"; 
		
		try {
			log.info("inicia Listar Cronograma");
			Query query = session.createSQLQuery("CALL ConsultarCronograma(:idHorario,:idCronograma)").
					setParameter("idHorario", idHorario).setParameter("idCronograma", idCronograma);
			/*Query query = session.createSQLQuery("CALL obtenerPlanificacionXPeriodoXActividad(:val_idperiodo,:val_estado)").addEntity(Cronograma.class).
					setParameter("idHorario", idHorario).setParameter("val_estado", idHorario);*/
			List<Object[]> objs  = query.list();
			
			listaCronograma = new ArrayList<Cronograma>();
			for (Object[] o : objs) {
				Object[] aux = o;
				Cronograma c = new Cronograma();

				c.setIdCronograma((Integer)aux[0]);
				c.setTarea((String)aux[1]);
				c.setDescripcion((String)aux[2]);
				//c.getEmpleado().setApellidoPat((String)aux[3]);
				//c.setEmpleado(new Empleado().setApellidoPat(''););
				c.setFechaInicio((Date)aux[5]);
				c.setFechaFin((Date)aux[5]);
				
				
				listaCronograma.add(c);
			}
			
			log.info("Registros encontrados PlanificacionPeriodoActividad: "  + listaCronograma.size());
			
			
			ts.commit();
			session.close();
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		
		
		return listaCronograma;
	}
	
	/*
	@SuppressWarnings("unchecked")
	@Override
	public List<Cronograma> listarCronograma(int idHorario) {
		// TODO Auto-generated method stub
		
		List<Cronograma> listaCronograma = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Cronograma  WHERE idHorario = :idHorario"; 
		
		try {
			listaCronograma = session.createSQLQuery(hql).list();
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
	}*/

	
	
	
}
