package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.tests.TestModificaHibernate;

public class FactoryTestModifica implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestModificaHibernate());
		
		return out;
	}

}
