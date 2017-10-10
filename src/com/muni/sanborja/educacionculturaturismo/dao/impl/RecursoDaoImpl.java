package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.RecursoDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Material;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class RecursoDaoImpl implements Serializable, RecursoDao{

	public static Logger log = Logger.getLogger(RecursoDaoImpl.class);
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> listarMateriales(String nombre) {
		List<Material> materiales = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String sql="FROM Material WHERE nombre like :nombre ";
		
		try {
			log.info("nombre material " + nombre);
			
			materiales = session.createQuery(sql).setParameter("nombre", "%"+nombre+"%").list();
			
			if (materiales == null) {
				log.info("No hay materiales asociados al nombre: " + nombre);
				
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

	@Override
	public boolean guardarRecurso(Recurso recurso) {
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			if(recurso == null)
				log.info("Recurso is null");
			
			session.save(recurso);
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
	public List<Recurso> listarRecursos(int idHorario) {
		List<Recurso> recursos = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String sql="FROM Recurso as res JOIN res.primaryKey.material  as mat "
				+ "JOIN res.primaryKey.horario as hor "
				+ "WHERE hor.idHorario = :idHorario";
		
		try {
			log.info("código Horario " + idHorario);
			
			recursos = session.createQuery(sql).setParameter("idHorario", idHorario).list();
			
			if (recursos == null) {
				log.info("No hay recursos asociados al código de horario: " + idHorario);
				
			} else {
				log.info("[Recursos] Se encontró " + recursos.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return null;
	}

}
