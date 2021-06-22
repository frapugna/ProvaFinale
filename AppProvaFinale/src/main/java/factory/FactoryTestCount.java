package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;

import hibernateClasses.tests.TestCountHibernate;

import jdbcClasses.tests.TestCountJDBC;

public class FactoryTestCount implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestCountHibernate());
		
		out.add(new TestCountJDBC());
		
		return out;
	}

}
