package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.sqliteTests.TestModificaHibernateSqlite;
import hibernateClasses.tests.TestModificaHibernate;
import jdbcClasses.sqliteTests.TestModificaJDBCSqlite;
import jdbcClasses.tests.TestModificaJDBC;

public class FactoryTestModifica implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestModificaHibernate());
		
		out.add(new TestModificaJDBC());
		
		out.add(new TestModificaHibernateSqlite());
		
		out.add(new TestModificaJDBCSqlite());
		
		return out;
	}

}
