package hibernateClasses.sqliteTests;

import org.hibernate.Session;
import org.hibernate.query.Query;

import core.Esito;
import core.Test;

import hibernateClasses.HibernateSessionManagerSqlite;

public class TestCountHibernateSqlite extends Test{
	@Override
	public void run() {
		long start = System.nanoTime();
		
		Session session = HibernateSessionManagerSqlite.getSession();
		Query<?> query=session.createQuery("select count(*) from GattoHibernate as g where g.colore like :colore");
		query.setParameter("colore","nero");
		Long num = (Long)query.uniqueResult();
		
		long end = System.nanoTime();
//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms, trovati "+num+" elementi");
		setEsito(new Esito("Test operazione di count Hibernate Sqlite:"+(end-start)/1000000 + "ms; Elementi trovati: "+num ));
	}
}
