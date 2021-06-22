package prove;

import java.sql.SQLException;

import core.Test;
import hibernateClasses.sqliteTests.TestGroupByHibernateSqlite;
import jdbcClasses.JDBCManagerSqlite;
import jdbcClasses.sqliteTests.TestCancellazioneJDBCSqlite;
import jdbcClasses.sqliteTests.TestCountJDBCSqlite;
import jdbcClasses.sqliteTests.TestGroupByJDBCSqlite;
import jdbcClasses.sqliteTests.TestInserimentoJDBCSqlite;
import jdbcClasses.sqliteTests.TestModificaJDBCSqlite;

public class ProveSqliteJDBC {

	public static void main(String[] args) {
		try {
			JDBCManagerSqlite.setup();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("oki");
		
		Test t1 = new TestInserimentoJDBCSqlite();
		t1.run();
		
		Test t2 = new TestCountJDBCSqlite();
		t2.run();
		
		Test t3 = new TestModificaJDBCSqlite();
		t3.run();
		Test t4 = new TestGroupByJDBCSqlite();
		t4.run();
		Test t5 = new TestCancellazioneJDBCSqlite();
		t5.run();
		System.out.println(t1.showResult());
		System.out.println(t2.showResult());
		System.out.println(t3.showResult());
		System.out.println(t4.showResult());
		System.out.println(t5.showResult());
	}

}
