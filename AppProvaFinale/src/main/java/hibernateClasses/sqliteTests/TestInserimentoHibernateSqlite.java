package hibernateClasses.sqliteTests;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.Esito;
import core.Test;
import hibernateClasses.GattoHibernate;
import hibernateClasses.HibernateSessionManagerSqlite;


public class TestInserimentoHibernateSqlite extends Test{
	private void newCat(String nome, String colore, Session session) {
		GattoHibernate gatto = new GattoHibernate(nome,colore);
		session.save(gatto);
	}
	@Override
	public void run() {

		Random r = new Random();
		String[] colori = {"Rosso", "Bianco", "Nero"};
		long start = System.nanoTime();
		try(Session session = HibernateSessionManagerSqlite.getSession()) {
			Transaction tx = session.beginTransaction();
			for(int i = 0; i<1000; ++i) {
				newCat(Integer.toString(i), colori[r.nextInt(3)], session);	
			}
			tx.commit();

		}
		long end = System.nanoTime(); 
//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms");
		setEsito(new Esito("Test inserimento valori Hibernate Sqlite:"+(end-start)/1000000 + "ms; Valori inseriti: 1000" ));
	}
}
