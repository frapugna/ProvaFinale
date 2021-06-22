package jdbcClasses.tests;

import java.sql.SQLException;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManager;

public class TestCancellazioneJDBC extends Test{

	@Override
	public void run() {
		long start = System.nanoTime();
		
		long eliminati=0;
		try {
			eliminati = JDBCManager.executeUpdateMysql("DELETE FROM `testdbjdbc`.`gatto`;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime(); 
		setEsito(new Esito("Test eliminazione valori JDBC Mysql: "+(end-start)/1000000 + "ms; Valori eliminati: "+eliminati));
	}

}
