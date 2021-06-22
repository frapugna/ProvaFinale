package hibernateClasses.sqliteTests;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import core.Esito;
import core.Test;
import hibernateClasses.GattoDaEsposizioneHibernate;
import hibernateClasses.GattoHibernate;
import hibernateClasses.HibernateSessionManagerSqlite;
import hibernateClasses.VotoHibernate;

public class TestGroupByHibernateSqlite extends Test{

	private void newGattoEsposizione(String nome, String colore, String razza, VotoHibernate voto, Session session) {

		GattoHibernate gatto = new GattoDaEsposizioneHibernate(nome,colore,razza,voto);
		session.save(gatto);		
		
	}
	
	@Override
	public void run() {
		//inserisco nuovi Gatti Da Esposizione con le rispettive valutazioni
		Random r = new Random();
		String[] colori = {"Rosso", "Bianco", "Nero"};
		String[] razze = {"American Curl", "Burmilla", "Siberiano"}; 
		try(Session session = HibernateSessionManagerSqlite.getSession()) {
			Transaction tx = session.beginTransaction();
			for(int i = 0; i<1000; ++i) {
				newGattoEsposizione(Integer.toString(i), colori[r.nextInt(3)],razze[r.nextInt(3)], new VotoHibernate(r.nextInt(11)),session);	
			}
			tx.commit();
		}
		long start = System.nanoTime();
		
		Session session = HibernateSessionManagerSqlite.getSession();
		Query<?> query=session.createQuery("select avg(v.valutazione) from GattoDaEsposizioneHibernate as g, VotoHibernate as v where v.id=g.valutazione group by g.colore");
		String esito = query.list().toString();

		
		Long end = System.nanoTime(); 
//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms");
		setEsito(new Esito("Test GroupBy Hibernate Sqlite:"+(end-start)/1000000 + "ms; Medie calcolate: "+esito ));
	}
}
