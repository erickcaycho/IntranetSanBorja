package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
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

	@SuppressWarnings("unchecked")
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
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
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
		String hql="FROM Empleado AS EMP INNER JOIN fetch EMP.roles AS DET WHERE DET.idrol = " +v_idrol ;
		
		try {
			
			lista  = session.createQuery(hql).list();
			
			if (lista == null) {
				log.info("No hay Empleado para ese Rol");
				
			} else {
				log.info("Se encontro " + lista.size());
			}
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
		}
		
		
		return lista;
	}

	@Override
	public boolean asignarEncargados(Empleado empleado) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		


		Horario horario = new Horario();
		horario.setIdHorario(90);
		List<Horario> lstHorario = new ArrayList<Horario>();
		lstHorario.add(horario);
		empleado.setHorarios(lstHorario);
		
		try {
			session.beginTransaction();
			if(empleado == null) {
				log.info("empleado es null");
			}else {
				session.save(empleado);
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

	
	
	
}
