package prove;

import core.Test;
import hibernateClasses.HibernateSessionManagerSqlite;
import hibernateClasses.sqliteTests.TestCancellazioneHibernateSqlite;
import hibernateClasses.sqliteTests.TestCountHibernateSqlite;
import hibernateClasses.sqliteTests.TestGroupByHibernateSqlite;
import hibernateClasses.sqliteTests.TestInserimentoHibernateSqlite;
import hibernateClasses.sqliteTests.TestModificaHibernateSqlite;
import jdbcClasses.tests.TestCancellazioneJDBC;
import jdbcClasses.tests.TestCountJDBC;
import jdbcClasses.tests.TestGroupByJDBC;
import jdbcClasses.tests.TestInserimentoJDBC;
import jdbcClasses.tests.TestModificaJDBC;

public class ProvaSqliteHibernate {

	public static void main(String[] args) {
		HibernateSessionManagerSqlite.setup();
		System.out.println("setup ok");
		Test t1 = new TestInserimentoHibernateSqlite();
		t1.run();
		
		
		Test t2 = new TestModificaHibernateSqlite();
		t2.run();
		
		
		Test t3 = new TestCountHibernateSqlite();
		t3.run();
	
		Test t4 = new TestGroupByHibernateSqlite();
		t4.run();
		
		
		Test t5 = new TestCancellazioneHibernateSqlite();
		t5.run();
		
		
		System.out.println(t1.showResult());
		System.out.println("Esito: "+t2.showResult());
		System.out.println("Esito: "+t3.showResult());
		System.out.println("Esito: "+t4.showResult());
		System.out.println("Esito: "+t5.showResult());
	}

}
