package jdbcClasses;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCManagerSqlite {
	
	protected static Statement statementSqlite;
	protected static Connection connectionSqlite;

	public static void setup() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connectionSqlite = DriverManager.getConnection("jdbc:sqlite:TestDBJDBCSqlite.db");
		statementSqlite = connectionSqlite.createStatement();
	
		String[] tables = {"gatto", "gattodaesposizione", "cattovet","voto","veterinario"};
		
		for(String i:tables)
			statementSqlite.executeUpdate("drop table if exists "+ i);
		
		statementSqlite.executeUpdate("CREATE TABLE voto (\r\n"
				+ "  id INT NOT NULL,\r\n"
				+ "  valutazione INT NULL,\r\n"
				+ "  PRIMARY KEY (id));");
		statementSqlite.executeUpdate("CREATE TABLE veterinario (\r\n"
				+ "  nome VARCHAR(45) NOT NULL,\r\n"
				+ "  cognome VARCHAR(45) NOT NULL,\r\n"
				+ "  CF VARCHAR(45) NULL,\r\n"
				+ "  PRIMARY KEY (nome, cognome));");
		statementSqlite.executeUpdate("CREATE TABLE gatto (\r\n"
				+ "  id INT NOT NULL,\r\n"
				+ "  colore VARCHAR(45) NULL,\r\n"
				+ "  nome VARCHAR(45) NULL,\r\n"
				+ "  PRIMARY KEY (id));");
		statementSqlite.executeUpdate("CREATE TABLE cattovet (\r\n"
				+ "  nome VARCHAR(45) NOT NULL,\r\n"
				+ "  cognome VARCHAR(45) NOT NULL,\r\n"
				+ "  id_gatto VARCHAR(45) NOT NULL,\r\n"
				+ "  PRIMARY KEY (nome, cognome, id_gatto));");
		statementSqlite.executeUpdate("CREATE TABLE gattodaesposizione (\r\n"
				+ "  id INT NOT NULL,\r\n"
				+ "  colore VARCHAR(45) NULL,\r\n"
				+ "  nome VARCHAR(45) NULL,\r\n"
				+ "  razza VARCHAR(45) NULL,\r\n"
				+ "  id_voto INT NULL,\r\n"
				+ "  PRIMARY KEY (id));");
		
	}

	public void showMetadata() throws SQLException {
		DatabaseMetaData md = connectionSqlite.getMetaData();

		System.out.println("-- ResultSet Type --");
		System.out.println("Supports TYPE_FORWARD_ONLY: "
				+ md.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));
		System.out.println("Supports TYPE_SCROLL_INSENSITIVE: "
				+ md.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
		System.out.println("Supports TYPE_SCROLL_SENSITIVE: "
				+ md.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

		System.out.println("-- ResultSet Concurrency --");
		System.out.println("Supports CONCUR_READ_ONLY: "
				+ md.supportsResultSetType(ResultSet.CONCUR_READ_ONLY));
		System.out.println("Supports CONCUR_UPDATABLE: "
				+ md.supportsResultSetType(ResultSet.CONCUR_UPDATABLE));
	}

	public static ResultSet executeQuerySqlite(String query) throws SQLException {
		return statementSqlite.executeQuery(query);
	}

	public static int executeUpdateSqlite(String query) throws SQLException {
		return statementSqlite.executeUpdate(query);
	}

	public static void closeMysql() throws SQLException {
		if (connectionSqlite != null) {
			statementSqlite.close();
			connectionSqlite.close();
		}
	}
	
}
