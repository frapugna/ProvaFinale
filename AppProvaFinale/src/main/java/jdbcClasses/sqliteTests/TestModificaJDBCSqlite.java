package jdbcClasses.sqliteTests;

import java.sql.SQLException;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManagerSqlite;

public class TestModificaJDBCSqlite extends Test{
	@Override
	public void run() {
		long start = System.nanoTime();
		
		long modificati=0;
		try {
			modificati = JDBCManagerSqlite.executeUpdateSqlite("UPDATE gatto as g SET colore = 'magenta' WHERE (g.colore like 'bianco');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime(); 
		setEsito(new Esito("Test modifica valori JDBC Sqlite: "+(end-start)/1000000 + "ms; Valori modificati: "+modificati));
	
		
	}
}
