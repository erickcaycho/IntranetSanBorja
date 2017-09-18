package com.muni.sanborja.educacionculturaturismo.util;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public final class HibernateSessionFactory implements Serializable {

	private static final long serialVersionUID = 3274791954897032857L;
	private static SessionFactory sessionFactory;
	private static final String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";

	private static Configuration configuration;

	static {
		try {
			configuration = new AnnotationConfiguration();
			configuration.configure(CONFIG_FILE_LOCATION);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close(Session session) {
		try {
			if (session != null) {
				session.close();
			}
		} catch (Exception e) {
			// LOG.error(e.getMessage(),e);
		}
	}

	public static void flush(Session session) {
		try {
			if (session != null) {
				session.flush();
			}
		} catch (Exception e) {
			// LOG.error(e.getMessage(),e);
		}
	}

	public static void rollback(Transaction tx) {
		try {
			if (tx != null) {
				tx.rollback();
				;
			}
		} catch (Exception e) {
			// LOG.error(e.getMessage(),e);
		}
	}
}
