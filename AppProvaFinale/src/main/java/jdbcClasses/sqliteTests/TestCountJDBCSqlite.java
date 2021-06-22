package jdbcClasses.sqliteTests;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManagerSqlite;

public class TestCountJDBCSqlite extends Test{

	@Override
	public void run() {
		long start = System.nanoTime();
		
		int out = 0;

		try {
			ResultSet rs = JDBCManagerSqlite.executeQuerySqlite("select count(*) from gatto as g WHERE (g.colore like 'nero');");
			rs.next();
			out = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.nanoTime(); 
		setEsito(new Esito("Test operazione di count JDBC Sqlite: "+(end-start)/1000000 + "ms; Elementi trovati: "+out));
		
	}

}
