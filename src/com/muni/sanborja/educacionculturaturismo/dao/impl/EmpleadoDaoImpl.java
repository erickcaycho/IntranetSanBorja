package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
import com.muni.sanborja.educacionculturaturismo.modelo.Horario;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class EmpleadoDaoImpl implements Serializable,EmpleadoDao{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(PeriodoDaoImpl.class);

	@Override
	public List<Empleado> listarEmpleado() {
		// TODO Auto-generated method stub
		List<Empleado> listaEmpleados = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="FROM Empleado";
		
		try {
			
			listaEmpleados  = session.createQuery(hql).list();
			
			if (listaEmpleados == null) {
				log.info("No hay Empleado");
				
			} else {
				log.info("Se encontro " + listaEmpleados.size());
			}
			
			ts.commit();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}finally {
			session.close();
		}
		
		
		return listaEmpleados;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> listarEmpleadoByRol(int v_idrol) {
		// TODO Auto-generated method stub
		List<Empleado> lista = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String hql="SELECT DISTINCT EMP FROM Empleado EMP INNER JOIN"
				+ " EMP.roles DET WHERE DET.idrol = " +v_idrol;
		
		try {
			
			lista  = session.createQuery(hql).list();
			
			if (lista == null) {
				log.info("No hay Empleado para ese Rol");
				
			} else {
				log.info("Se encontro " + lista.size());
			}
			
			ts.commit();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}finally {
			session.close();
		}
		
		
		return lista;
	}

	@Override
	public boolean asignarEncargados(Horario horario, List<Empleado> lstEmpleado) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		

		
		
		try {
			
			session.beginTransaction();
			if(horario == null || lstEmpleado == null ) {
				log.info("horario es null");
			}else {
				
				horario.setEmpleados(lstEmpleado);
				
				
				
				session.update(horario);
				session.beginTransaction().commit();
				
				log.info("Guardado correctamente");
				flag=true;
			}

			
		} catch (Exception e) {
			session.beginTransaction().rollback();
			
			log.error("error " +e.getMessage());
		    e.getMessage();
		}finally {
			session.close();
		}
		
		return flag;
	}

	
	@Override
	public Empleado buscar(int idEmpleado) {
		Empleado empleado = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
			
	       try {
	    	   empleado = (Empleado) session.get(Empleado.class, idEmpleado); 
	        } catch (Exception e) {
				session.beginTransaction().rollback();
				
				log.error("error " +e.getMessage());
				  e.getMessage();
			}finally {
				session.close();
			}
	      return empleado; 
	 }

	@Override
	public List listarEncargados(int idHorario) {
		// TODO Auto-generated method stub
		List lista = null;
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		
		String hql="SELECT new 	list(e.idEmpleado,concat(e.nombre, ' ', e.apellidoPat, ' ', e.apellidoMat) ,r.nombrerol) FROM Empleado e " + 
		"inner join  e.horarios h " + 
		"inner join  e.roles r " + 
		" where h.idHorario=" +idHorario;
		
		
		try {
			lista  = session.createQuery(hql).list();
			
			if (lista == null) {
				log.info("No hay Encargados para el Horario seleccionado");
				
			} else {
				log.info("Se encontro " + lista.size());
			}
			
			ts.commit();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
		}finally {
			session.close();
		}
		
		
		return lista;
	}
	
	
	
}
