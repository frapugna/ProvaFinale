package hibernateClasses.sqliteTests;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import core.Esito;
import core.Test;
import hibernateClasses.HibernateSessionManagerSqlite;

public class TestCancellazioneHibernateSqlite extends Test{
	@Override
	public void run() {
	
		long start = System.nanoTime();
		
		Session session = HibernateSessionManagerSqlite.getSession();
		Transaction tx = session.beginTransaction();
		Query<?> query=session.createQuery("delete from GattoHibernate");
		
		long eliminati = query.executeUpdate();
		tx.commit();
		
		long end = System.nanoTime(); 
//		System.out.println("Test eliminazione valori hibernate: "+(end-start)/1000000 + "ms");
		setEsito(new Esito("Test eliminazione valori hibernate Sqlite: "+(end-start)/1000000 + "ms; Valori eliminati: "+eliminati));
	}
	
}
