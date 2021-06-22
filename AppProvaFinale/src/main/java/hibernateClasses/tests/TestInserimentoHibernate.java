package hibernateClasses.tests;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.Esito;
import core.Test;
import hibernateClasses.GattoHibernate;
import hibernateClasses.HibernateSessionManager;
import hibernateClasses.VeterinarioHibernate;

public class TestInserimentoHibernate extends Test{

	private void newCat(String nome, String colore, VeterinarioHibernate veterinario, Session session) {
		GattoHibernate gatto = new GattoHibernate(nome,colore);
		gatto.addVeterinario(veterinario);
		session.save(gatto);
	}
	@Override
	public void run() {

		Random r = new Random();
		VeterinarioHibernate[] veterinari = {
				new VeterinarioHibernate("PFKPFKFP1212", "Mario", "Rossi"),
				new VeterinarioHibernate("PFLSKSKFP1212", "Laura", "Bianchi"), 
				new VeterinarioHibernate("BKBKBKBKFP1212", "Sam", "Bucket")
		};
		String[] colori = {"Rosso", "Bianco", "Nero"};
		long start = System.nanoTime();
		try(Session session = HibernateSessionManager.getSession()) {
			Transaction tx = session.beginTransaction();
			for(int i = 0; i<1000; ++i) {
				newCat(Integer.toString(i), colori[r.nextInt(3)], veterinari[r.nextInt(3)], session);	
			}
			tx.commit();

		}
		long end = System.nanoTime(); 
//		System.out.println("Tempo esecuz: " + (end-start)/1000000 + "ms");
		setEsito(new Esito("Test inserimento valori Hibernate Mysql:"+(end-start)/1000000 + "ms; Valori inseriti: 1000" ));
	}

}
