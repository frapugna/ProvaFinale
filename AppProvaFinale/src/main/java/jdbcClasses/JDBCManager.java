package jdbcClasses;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCManager {
	public static final String JDBCDriverSQLite = "org.sqlite.JDBC";
	public static final String JDBCURLSQLite = "jdbc:sqlite:test.db";

	protected static Statement statementMysql;
	protected static Connection connectionMysql;

	public static void setup() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connectionMysql = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","(t3si2021ConGuerra)");
		statementMysql = connectionMysql.createStatement();
	
		statementMysql.executeUpdate("create schema if not exists TestDBjdbc");
		String[] tables = {"gatto", "gattodaesposizione", "cattovet","voto","veterinario"};
		
		for(String i:tables)
			statementMysql.executeUpdate("drop table if exists  `TestDBjdbc`.`"+ i +"`");
		
		statementMysql.executeUpdate("CREATE TABLE `TestDBjdbc`.`voto` (\r\n"
				+ "  `id` INT NOT NULL,\r\n"
				+ "  `valutazione` INT NULL,\r\n"
				+ "  PRIMARY KEY (`id`));");
		statementMysql.executeUpdate("CREATE TABLE `TestDBjdbc`.`veterinario` (\r\n"
				+ "  `nome` VARCHAR(45) NOT NULL,\r\n"
				+ "  `cognome` VARCHAR(45) NOT NULL,\r\n"
				+ "  `CF` VARCHAR(45) NULL,\r\n"
				+ "  PRIMARY KEY (`nome`, `cognome`));");
		statementMysql.executeUpdate("CREATE TABLE `TestDBjdbc`.`gatto` (\r\n"
				+ "  `id` INT NOT NULL,\r\n"
				+ "  `colore` VARCHAR(45) NULL,\r\n"
				+ "  `nome` VARCHAR(45) NULL,\r\n"
				+ "  PRIMARY KEY (`id`));");
		statementMysql.executeUpdate("CREATE TABLE `testdbjdbc`.`cattovet` (\r\n"
				+ "  `nome` VARCHAR(45) NOT NULL,\r\n"
				+ "  `cognome` VARCHAR(45) NOT NULL,\r\n"
				+ "  `id_gatto` VARCHAR(45) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`nome`, `cognome`, `id_gatto`));");
		statementMysql.executeUpdate("CREATE TABLE `testdbjdbc`.`gattodaesposizione` (\r\n"
				+ "  `id` INT NOT NULL,\r\n"
				+ "  `colore` VARCHAR(45) NULL,\r\n"
				+ "  `nome` VARCHAR(45) NULL,\r\n"
				+ "  `razza` VARCHAR(45) NULL,\r\n"
				+ "  `id_voto` INT NULL,\r\n"
				+ "  PRIMARY KEY (`id`));");
		
	}

	public void showMetadata() throws SQLException {
		DatabaseMetaData md = connectionMysql.getMetaData();

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

	public static ResultSet executeQueryMysql(String query) throws SQLException {
		return statementMysql.executeQuery(query);
	}

	public static int executeUpdateMysql(String query) throws SQLException {
		return statementMysql.executeUpdate(query);
	}

	public static void closeMysql() throws SQLException {
		if (connectionMysql != null) {
			statementMysql.close();
			connectionMysql.close();
		}
	}
}


