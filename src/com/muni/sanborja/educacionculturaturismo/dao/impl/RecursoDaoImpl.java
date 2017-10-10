package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
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
			if(recurso == null) {
				log.info("Recurso is null");
				return false;
			}
			
			session.beginTransaction();
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

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Recurso> listarRecursos(int idHorario) {
		List<Recurso> recursos = new ArrayList<Recurso>();
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String sql="FROM Recurso as res JOIN res.primaryKey.material  as mat "
				+ "JOIN res.primaryKey.horario as hor "
				+ "WHERE hor.idHorario = :idHorario";
		
		try {
			log.info("código Horario " + idHorario);
			
			List<Object[]> objs = session.createQuery(sql).setParameter("idHorario", idHorario).list();
			
			for (Object[] o : objs) {
				Object[] aux = o;
				Recurso recurso = (Recurso) aux[0];
				
				recursos.add(recurso);
			}
			
			if (recursos == null) 
				log.info("No hay recursos asociados al código de horario: " + idHorario);
			else
				log.info("[Recursos] Se encontró " + recursos.size());
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return recursos;
	}

	@Override
	public boolean actualizarCantidadMaterial(Material material, int cantidad) {

		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		boolean stateUpdate = false;
		String sql ="update Material set cantidadDisponible = :cantidadDisponible" +
				" where idMaterial = :idMaterial";
		
		try {
			log.info("código Horario " + material.getIdMaterial());
			
			Query query = session.createQuery(sql);
			query.setParameter("cantidadDisponible", cantidad);
			query.setParameter("idMaterial", material.getIdMaterial());
			int result = query.executeUpdate();
			
			stateUpdate = result != 0;
			
			if (stateUpdate) 
				log.info("Se actualizó el material con id: "+material.getIdMaterial());
			else 
				log.info("No se pudo actualizar el material con id: "+material.getIdMaterial());
			
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return stateUpdate;
	}

	@Override
	public boolean eliminarRecurso(Recurso recurso) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		boolean stateDelete = false;
		
		String sql ="delete Recurso as res WHERE res.primaryKey.material.idMaterial = :idMaterial "
				+ "AND res.primaryKey.horario.idHorario = :idHorario";
		
		try {
			log.info("código Horario: " + recurso.getHorario().getIdHorario() + ", código Material: "+recurso.getMaterial().getIdMaterial());
			
			Query query = session.createQuery(sql);
			query.setParameter("idMaterial", recurso.getMaterial().getIdMaterial());
			query.setParameter("idHorario", recurso.getHorario().getIdHorario());
			int result = query.executeUpdate();
			
			stateDelete = result != 0;
			
			if (stateDelete) 
				log.info("Se eliminó el recurso");
			else
				log.info("No se pudo eliminar el recurso");
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return stateDelete;
	}

	@Override
	public boolean actualizarCantidadMaterial(Recurso recurso) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Material material;
		int cantidadDisponible;
		String hql;
		boolean stateUpdate = false;
		
		try {
			log.info("nombre material " + recurso.getMaterial().getIdMaterial());
			
			material = (Material) session.get(Material.class, recurso.getMaterial().getIdMaterial());
			
			if (material == null) {
				log.info("No hay materiales asociados al id: " + recurso.getMaterial().getIdMaterial());
				
			} else {
				cantidadDisponible = material.getCantidadDisponible() + recurso.getCantidadUsar();
				hql ="update Material set cantidadDisponible = :cantidadDisponible" +
						" where idMaterial = :idMaterial";
				
				Query query = session.createQuery(hql);
				query.setParameter("cantidadDisponible", cantidadDisponible);
				query.setParameter("idMaterial", material.getIdMaterial());
				int result = query.executeUpdate();
				
				stateUpdate = result != 0;
				
				if (stateUpdate) 
					log.info("Se actualizó el material con id: "+material.getIdMaterial());
				else 
					log.info("No se pudo actualizar el material con id: "+material.getIdMaterial());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return stateUpdate;
	}

}
