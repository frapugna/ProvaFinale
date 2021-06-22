package jdbcClasses.sqliteTests;

import java.sql.SQLException;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManagerSqlite;

public class TestCancellazioneJDBCSqlite extends Test{
	@Override
	public void run() {
		long start = System.nanoTime();
		
		long eliminati=0;
		try {
			eliminati = JDBCManagerSqlite.executeUpdateSqlite("DELETE FROM gatto;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime(); 
		setEsito(new Esito("Test eliminazione valori JDBC Sqlite: "+(end-start)/1000000 + "ms; Valori eliminati: "+eliminati));
	}
}
