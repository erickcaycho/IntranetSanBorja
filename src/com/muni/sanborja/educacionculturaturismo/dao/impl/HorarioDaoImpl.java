package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.muni.sanborja.educacionculturaturismo.dao.HorarioDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.modelo.HorarioPlanificacionActividad;
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
			if(horario == null) {
				log.info("Horario es null");
			}else {
				session.save(horario);
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
	public List<Horario> listarHorario(int idPlanificacion) {
		List<Horario> listaHorario = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("Listar Horario "+idPlanificacion);
			//Query query  
			listaHorario = session.createQuery("FROM Horario  WHERE idplanificacion = :idplanificacion").
				setParameter("idplanificacion",idPlanificacion).list();
			//listaHorario = query.list();
			
			log.info("Registros encontrados Horario: "  + listaHorario.size());
			
			ts.commit();
			session.close();
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return listaHorario;
	}

	@Override
	public List<HorarioPlanificacionActividad> listarHorarioPlanificacionActividad() {
		List<HorarioPlanificacionActividad> horario = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("inicia HorarioPlanificacionActividad");
			
			Query query = session.createSQLQuery("CALL ConsultarHorario()");
			List<Object[]> objs  = query.list();
			
			horario  = new ArrayList<HorarioPlanificacionActividad>();
			
			for (Object[] o : objs) {
				Object[] aux = o;
				HorarioPlanificacionActividad h = new HorarioPlanificacionActividad();
				
				h.setIdHorario((Integer)aux[0]);
				h.setNombreSede((String)aux[1]);
				h.setNombreAmbiente((String)aux[2]);
				h.setDirigido((String)aux[3]);
				h.setCantidadSesion((Integer)aux[4]);
				h.setHoraSesion((Integer)aux[5]);
				h.setVacanteMin((Integer)aux[6]);
				h.setVacanteMax((Integer)aux[7]);
				h.setFechaInicio((Date)aux[8]);
				h.setFechaFin((Date)aux[9]);
				h.setPrecio((Double)aux[10]);
				
				horario.add(h);
			}
			
			log.info("Registros encontrados HorarioPlanificacionActividad: "  + horario.size());
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return horario;
	}
	
	
}
