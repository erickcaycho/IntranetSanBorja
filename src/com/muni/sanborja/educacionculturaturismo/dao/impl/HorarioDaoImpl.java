package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
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
			if(horario == null) {
				log.info("cronograma es null");
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
		
		String hql="FROM Horario  WHERE idplanificacion = :idplanificacion";
		
		Query query = session.createSQLQuery("CALL ConsultarHorario(:idPlanificacion)").
					setParameter("idPlanificacion",idPlanificacion);
		
		try {
			log.info("Listar Horario");
			
			List<Object[]> objs  = query.list();
			
			listaHorario = new ArrayList<Horario>();
			for (Object[] o : objs) {
				Object[] aux = o;
				Horario h = new Horario();
				/*h.setIdHorario((Integer)aux[0]);
				h.setEdadMax(edadMax);
				h.setEdadMin(edadMin);
				h.setFechaInicio(fechaInicio);
				h.setFechafin(fechafin);
				h.setHorassesion(horassesion);
				h.setVacantemax(vacantemax);
				h.setVacantemin(vacantemin);
				h.setCantsesion(cantsesion);*/
				listaHorario.add(h);
			}
			
			log.info("Registros encontrados PlanificacionPeriodoActividad: "  + listaHorario.size());
			
			ts.commit();
			session.close();
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return listaHorario;
	}
	
}
