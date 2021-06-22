package launchcode;

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

public class App {

	public static void main(String[] args) {
		HibernateSessionManager.setup();
		List<FactoryInterface> factories = new ArrayList<FactoryInterface>(Arrays.asList(	new FactoryTestInserimento(),
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
