package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.tests.TestModificaHibernate;
import jdbcClasses.tests.TestModificaJDBC;

public class FactoryTestModifica implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestModificaHibernate());
		
		out.add(new TestModificaJDBC());
		
		return out;
	}

}
