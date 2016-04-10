package amc.scda.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory	sessionFactory	= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings (cfg.getProperties()).buildServiceRegistry();
			
			return cfg.buildSessionFactory(serviceRegistry);
			
		} catch (Throwable e) {
			System.out.println("Cria��o inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	} 
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
