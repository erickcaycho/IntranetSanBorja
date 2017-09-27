package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.apache.log4j.Logger;

import com.muni.sanborja.educacionculturaturismo.dao.EmpleadoDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Empleado;
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
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		 
		}
		
		
		return listaEmpleados;
	}

	
	
	
}
