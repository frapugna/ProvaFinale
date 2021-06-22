package hibernateClasses.tests;

import org.hibernate.Session;
import org.hibernate.query.Query;

import core.Esito;
import core.Test;
import hibernateClasses.HibernateSessionManager;

public class TestCountHibernate extends Test{

	@Override
	public void run() {
		long start = System.nanoTime();
		
		Session session = HibernateSessionManager.getSession();
		Query<?> query=session.createQuery("select count(*) from GattoHibernate where colore=:colore");
		query.setParameter("colore","nero");
		Long num = (Long)query.uniqueResult();
		
		long end = System.nanoTime();
//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms, trovati "+num+" elementi");
		setEsito(new Esito("Test operazione di count Hibernate:"+(end-start)/1000000 + "ms; Elementi trovati: "+num ));
	}

}
