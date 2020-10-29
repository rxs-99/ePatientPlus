package com.revature.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	/*
	 * This is a utility class for building a SessionFactory and returning
	 * Hibernate Sessions. Note that our SessionFactory will be a singleton
	 * as SessionFactory(ies) are expensive to build and we don't need more
	 * than one SessionFactory to retrieve a large number of sessions.
	 */
	
	private static SessionFactory sessionFactory;
	
	public static Session getSession() {
		
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", "jdbc:postgresql://revature.cfoumzokvjgu.us-east-2.rds.amazonaws.com/revature"/*System.getenv("dburl")*/) 
					.setProperty("hibernate.connection.username", "postgres"/*System.getenv("dbusername")*/)
					.setProperty("hibernate.connection.password", "KB[v&p\\f-*23j]7T"/*System.getenv("dbpassword")*/)
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
