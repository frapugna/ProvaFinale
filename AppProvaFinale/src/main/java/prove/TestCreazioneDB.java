package prove;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernateClasses.GattoHibernate;
import hibernateClasses.HibernateSessionManager;
import hibernateClasses.VeterinarioHibernate;
import hibernateClasses.tests.TestCancellazioneHibernate;
import hibernateClasses.tests.TestCountHibernate;
import hibernateClasses.tests.TestGroupByHibernate;
import hibernateClasses.tests.TestInserimentoHibernate;
import hibernateClasses.tests.TestModificaHibernate;
import hibernateClasses.tests.TestGroupByHibernate;
public class TestCreazioneDB {
	
	static public void testSaveGatto() {
		/*
		 * Metodo per testare il salvataggio di un obj Peson nel db connesso tramite hibernate
		 */
		long start = System.nanoTime();
		
		try(Session session = HibernateSessionManager.getSession()) {
			Transaction tx = session.beginTransaction();
			GattoHibernate gatto = new GattoHibernate("mario","nero");
			gatto.addVeterinario(new VeterinarioHibernate("CFFFF2", "marco", "lurco"));
			//		Aggiunta del salvataggio della persona appena creata alle cose da committare
			session.save(gatto);
			//		Commit effettivo delle modifiche effettuate al db
			GattoHibernate gatto2 = new GattoHibernate("gatto","blu");
			gatto2.addVeterinario(new VeterinarioHibernate("CFFFF2", "marc", "lurco"));
			//		Aggiunta del salvataggio della persona appena creata alle cose da committare
			session.save(gatto2);
			//		Commit effettivo delle modifiche effettuate al db
			tx.commit();
				
		}
		long end = System.nanoTime(); 
		System.out.println("Tempo esecuz: " + (end-start)/1000 + "ms");
	}
	
	public static void main(String[] args) {
		HibernateSessionManager.setup();
		TestInserimentoHibernate t = new TestInserimentoHibernate();
		t.run();
//		testSaveGatto();
		TestGroupByHibernate t2 = new TestGroupByHibernate();
//		t2.run();
		TestModificaHibernate t3 = new TestModificaHibernate();
//		t2.run();
		TestCountHibernate t4 = new TestCountHibernate();
//		t3.run();
		TestCancellazioneHibernate t5 = new TestCancellazioneHibernate();
//		t5.run();
//		System.out.println(t5.showResult());
		
	}

}
