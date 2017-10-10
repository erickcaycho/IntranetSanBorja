package com.muni.sanborja.educacionculturaturismo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.muni.sanborja.educacionculturaturismo.dao.DiaDao;
import com.muni.sanborja.educacionculturaturismo.modelo.Dia;
import com.muni.sanborja.educacionculturaturismo.modelo.Recurso;
import com.muni.sanborja.educacionculturaturismo.util.HibernateSessionFactory;

public class DiaDaoImpl implements DiaDao, Serializable{

	public static Logger log = Logger.getLogger(DiaDaoImpl.class);
	private static final long serialVersionUID = 1L;
	
	@Override
	public boolean asignarDia(Dia dia) {
		boolean flag;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		
		try {
			if(dia == null) {
				log.info("Recurso is null");
				return false;
			}
			
			session.beginTransaction();
			session.save(dia);
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
	public List<Dia> listarDias(int idHorario) {
		List<Dia> dias = new ArrayList<Dia>();
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		String sql="FROM Dia as dia JOIN res.horario as horario "
				+ "WHERE horario.idHorario = :idHorario";
		
		try {
			log.info("código Horario " + idHorario);
			
			List<Object[]> objs = session.createQuery(sql).setParameter("idHorario", idHorario).list();
			
			for (Object[] o : objs) {
				Object[] aux = o;
				Dia dia = (Dia) aux[0];
				
				dias.add(dia);
			}
			
			if (dias.size() == 0) 
				log.info("No hay recursos asociados al código de horario: " + idHorario);
			else
				log.info("[Recursos] Se encontró " + dias.size());
			
			ts.commit();
			session.close();
			
		} catch (Exception e) {
			log.error("error " +e.getMessage());
			  e.getMessage();
		}
		return dias;
	}

}
