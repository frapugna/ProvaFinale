package jdbcClasses.sqliteTests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import core.Esito;
import core.Test;
import jdbcClasses.JDBCManagerSqlite;
import jdbcClasses.VotoJDBC;

public class TestGroupByJDBCSqlite extends Test{
	private void newGattoDaEsposizione(long id, String colore, String nome, String razza, VotoJDBC voto) throws SQLException {
		JDBCManagerSqlite.executeUpdateSqlite("INSERT INTO voto (id, valutazione) VALUES ("+voto.getId()+", "+voto.getValutazione()+");");
		JDBCManagerSqlite.executeUpdateSqlite("INSERT INTO gattodaesposizione (id, colore, nome, razza, id_voto) VALUES ('"+id+"', '"+colore+"', '"+nome+"', '"+razza+"', '"+voto.getId()+"');");
		
	}

	@Override
	public void run() {
		Random r = new Random();
		String[] colori = {"Rosso", "Bianco", "Nero"};
		String[] razze = {"American Curl", "Burmilla", "Siberiano"}; 
		try {
			for(int i = 0; i< 1000; ++i) {

				newGattoDaEsposizione(i, colori[r.nextInt(3)], Integer.toString(i), razze[r.nextInt(3)],new VotoJDBC(i,r.nextInt(11)) );

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long start = System.nanoTime();
		String esito ="";
		try {
			ResultSet rs = JDBCManagerSqlite.executeQuerySqlite("select avg(v.valutazione) from gattodaesposizione as g, voto as v where g.id_voto = v.id group by g.colore;");
			while(rs.next()) {
				esito = esito + rs.getDouble(1) + "   ";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Long end = System.nanoTime(); 
		setEsito(new Esito("Test GroupBy JDBC Sqlite:"+(end-start)/1000000 + "ms; Medie calcolate: "+esito ));
	}

}
