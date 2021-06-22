package prove;

import java.sql.SQLException;

import core.Test;
import jdbcClasses.JDBCManager;
import jdbcClasses.tests.TestCancellazioneJDBC;
import jdbcClasses.tests.TestCountJDBC;
import jdbcClasses.tests.TestGroupByJDBC;
import jdbcClasses.tests.TestInserimentoJDBC;
import jdbcClasses.tests.TestModificaJDBC;

public class TestCreazioneDBMySQL {

	public static void main(String[] args) {
		try {
			JDBCManager.setup();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tto bn");
		
		Test t1 = new TestInserimentoJDBC();
		t1.run();
		System.out.println("Esito: "+t1.showResult());
		
		Test t2 = new TestModificaJDBC();
		t2.run();
		System.out.println("Esito: "+t2.showResult());
		
		Test t3 = new TestCountJDBC();
		t3.run();
		System.out.println("Esito: "+t3.showResult());
		Test t4 = new TestGroupByJDBC();
//		t4.run();
//		System.out.println("Esito: "+t4.showResult());
		
		Test t5 = new TestCancellazioneJDBC();
//		t5.run();
//		System.out.println("Esito: "+t5.showResult());
	}

}
