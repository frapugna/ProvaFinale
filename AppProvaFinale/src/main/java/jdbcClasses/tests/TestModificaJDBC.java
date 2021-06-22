package jdbcClasses.tests;

import java.sql.SQLException;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManager;

public class TestModificaJDBC extends Test{

	@Override
	public void run() {
		long start = System.nanoTime();
		
		long modificati=0;
		try {
			modificati = JDBCManager.executeUpdateMysql("UPDATE `testdbjdbc`.`gatto` SET `colore` = 'magenta' WHERE (`colore` = 'bianco');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime(); 
		setEsito(new Esito("Test modifica valori JDBC Mysql: "+(end-start)/1000000 + "ms; Valori modificati: "+modificati));
	
		
	}

}
