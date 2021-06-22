package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.tests.TestGroupByHibernate;
import jdbcClasses.tests.TestGroupByJDBC;

public class FactoryTestGroupBy implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestGroupByHibernate());
		
		out.add(new TestGroupByJDBC());
		
		return out;
	}

}
