package jdbcClasses.tests;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManager;

public class TestCountJDBC extends Test{

	@Override
	public void run() {
		long start = System.nanoTime();
		
		int out = 0;

		try {
			ResultSet rs = JDBCManager.executeQueryMysql("select count(*) from `testdbjdbc`.`gatto`WHERE (`colore` = 'nero');");
			rs.next();
			out = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime(); 
		setEsito(new Esito("Test operazione di count JDBC Mysql: "+(end-start)/1000000 + "ms; Elementi trovati: "+out));
		
	}

}
