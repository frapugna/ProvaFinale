package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.sqliteTests.TestInserimentoHibernateSqlite;
import hibernateClasses.tests.TestInserimentoHibernate;
import jdbcClasses.sqliteTests.TestInserimentoJDBCSqlite;
import jdbcClasses.tests.TestInserimentoJDBC;

public class FactoryTestInserimento implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestInserimentoHibernate());
		
		out.add(new TestInserimentoJDBC());
		
		out.add(new TestInserimentoHibernateSqlite());
		
		out.add(new TestInserimentoJDBCSqlite());
		
		return out;
	}

}
