package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.PlanificacionDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Ambiente;
import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Periodo;
import com.muni.sanborja.educacionculturaturismo.modelo.Planificacion;
import com.muni.sanborja.educacionculturaturismo.modelo.PlanificacionPeriodoActividad;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class PlanificacionDaoImpl implements PlanificacionDao, Serializable {

	public static Logger log = Logger.getLogger(PlanificacionDaoImpl.class);
	private static final long serialVersionUID = 3558653004795076773L;
	
	@Override
	public boolean create(Planificacion planificacion) {
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			if(planificacion == null)
				log.info("Planificación is null");
			
			session.save(planificacion);
			session.beginTransaction().commit();
			log.info("Guardado correctamente");
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

	@SuppressWarnings("unchecked")
	@Override
	public List<PlanificacionPeriodoActividad> listarPlanificacionPeriodoActividad(int idperiodo, int estado) {		

		log.info("---CONSULTAR ---");
		log.info("idPeriodo_capturado: " +idperiodo);
		log.info("Estado_capturado: " +estado);
		
		List<PlanificacionPeriodoActividad> plan  = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		try {
			log.info("inicia PlanificacionPeriodoActividad");
			Query query = session.createSQLQuery("CALL obtenerPlanificacionXPeriodoXActividad(:val_idperiodo,:val_estado)").setParameter("val_idperiodo", idperiodo).setParameter("val_estado", estado);
			List<Object[]> objs  = query.list();
			
			
			plan = new ArrayList<PlanificacionPeriodoActividad>();
			for (Object[] o : objs) {
				Object[] aux = o;
				PlanificacionPeriodoActividad p = new PlanificacionPeriodoActividad();
				
				p.setIdPlanificacion((Integer)aux[0]);
				p.setNomPeriodo((String)aux[1]);
				p.setFechaCreacion((Date)aux[2]);
				p.setFechaPlanificacion((Date)aux[3]);
				p.setFechaAprobacion((Date)aux[4]);
				p.setFechaRechazo((Date)aux[5]);
				p.setFechaAnulacion((Date)aux[6]);
				p.setFechaEjecucion((Date)aux[7]);
				p.setNomActividad((String)aux[8]);
				p.setNomTipoActividad((String)aux[9]);
				p.setEstado((String)aux[10]);
				
				plan.add(p);
			}
			
			log.info("Registros encontrados PlanificacionPeriodoActividad *: "  + plan.size());
			
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		
		log.info("Tam actual: " + plan.size());
		return plan;
	}

	@Override
	public boolean validarActividadPorPeriodo(int idPeriodo, int idTipoActividad, int idActividad) {
		
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		SQLQuery query = null;
		
		try {
			query = session.createSQLQuery("CALL validarActividadPorPeriodo(:idperiodo, :idtipoactividad, :idactividad)");
			query.setParameter("idperiodo", idPeriodo);
			query.setParameter("idtipoactividad", idTipoActividad);
			query.setParameter("idactividad", idActividad);
			
			Object resultado = query.uniqueResult();
			
			int numResultado = Integer.parseInt(resultado.toString());
			
			if(numResultado == 0){
				flag=true;
			}else{
				flag=false;
			}
			
			log.info("Resultado de validarActividadPorPeriodo: " + resultado.toString() + "- Flag: "+ flag);
			
			
		} catch (Exception e) {
			log.error("Error Resultado de validarActividadPorPeriodo " +e.getMessage());
			  e.getMessage();
			  
			  flag=false;
		}
		
		return flag;
	}

	public boolean delete(Planificacion planificacion) {
		
		log.info("---ELIMINAR PLAN SELECCIONADO---");
		log.info("Captura id_Planificacion: " +planificacion.getIdPlanificacion());
		
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.delete(planificacion);
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
	
	 public Planificacion buscar(int idPlanificacion) {
		 Planificacion planificacion = null;
		 Session session = HibernateSessionFactory.getSessionFactory().openSession();
			
	       try {
	    	   planificacion = (Planificacion) session.get(Planificacion.class, idPlanificacion); 
	        } catch (Exception e) {
				session.beginTransaction().rollback();
				
				log.error("error " +e.getMessage());
				  e.getMessage();
			}
	        return planificacion; 
	    }
	
	@Override
	public List<Planificacion> listarPlanificacion(int idperiodo, int idestado, int idtipoActividad, int idactividad) {
		List<Planificacion> listaPlanificacion = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Planificacion WHERE ";
				if(idperiodo!=0){
					hql+=" idperiodo = :idperiodo "; 
				}
				if(idestado!=0){
					hql+=" and estado = :idestado "; 
				}
				if(idtipoActividad!=0){
					hql+=" and actividad.tipoActividad.idTipoActividad = :idtipoActividad "; 
				}
				if(idactividad!=0){
					hql+=" and actividad.idActividad = :idactividad  "; 
				}
		try {
			
			listaPlanificacion = session.createQuery(hql)
					.setParameter("idperiodo",idperiodo).
					setParameter("idestado",idestado).
					setParameter("idtipoActividad",idtipoActividad).
					setParameter("idactividad",idactividad).list();
			if (listaPlanificacion == null) {
				log.info("No hay Planificaciones");
			} else {
				log.info("[Planificacion] Se encontro " + listaPlanificacion.size());
			}
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			session.close();
			log.error("error " +e.getMessage());
			e.getMessage();
		}
			return listaPlanificacion;
	}

	@Override
	public boolean updatePlanificacion(Planificacion plan) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql;
		boolean stateUpdate = false;
		
		try {
				hql ="update Planificacion set fechaPlanificacion = :fechaPlanificacion" +
						" where idPlanificacion = :idPlanificacion";
				
				Query query = session.createQuery(hql);
				query.setParameter("fechaPlanificacion", plan.getFechaPlanificacion());
				query.setParameter("idPlanificacion", plan.getIdPlanificacion());
				int result = query.executeUpdate();
				
				stateUpdate = result != 0;
				
				if (stateUpdate) 
					log.info("Se actualizó el plan con id: "+plan.getIdPlanificacion());
				else 
					log.info("No se pudo actualizar el plan con id: "+plan.getIdPlanificacion());
		
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return stateUpdate;
	}
}
