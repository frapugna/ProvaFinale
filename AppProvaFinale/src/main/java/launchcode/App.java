package launchcode;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import core.FactoryInterface;
import core.FactoryManager;
import core.TestManager;
import factory.FactoryTestCancellazione;
import factory.FactoryTestCount;
import factory.FactoryTestGroupBy;
import factory.FactoryTestInserimento;
import factory.FactoryTestModifica;
import gui.CLI;
import hibernateClasses.HibernateSessionManager;
import jdbcClasses.JDBCManager;

public class App {

	public static void main(String[] args) {
		HibernateSessionManager.setup();
		try {
			JDBCManager.setup();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<FactoryInterface> factories = new ArrayList<FactoryInterface>(Arrays.asList(	
				new FactoryTestInserimento(),
				new FactoryTestCount(),
				new FactoryTestModifica(),
				new FactoryTestGroupBy(), 																
				new FactoryTestCancellazione()));

		FactoryManager fm = new FactoryManager(factories);
		TestManager tm = new TestManager(fm.istantiate(), new CLI());
		do {
			tm.runAll();
			tm.displayAllResults();
		}while(tm.askForClose());

	}

}
