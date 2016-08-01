package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	private static ServiceRegistry serviceRegistry;
	static {
		try {
			configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			sessionFactory = null;
			ServiceRegistryBuilder.destroy(serviceRegistry);
		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
