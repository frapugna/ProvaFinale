package hibernateClasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionManager {
	static private SessionFactory factory;
	
	static public void setup() {
		/*
		 * Metodo che si occupa di creare un oggetto factory connettendosi al db indicato nel file .xml
		 */
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	static public Session getSession() {
		return factory.openSession();
	}
	
}
