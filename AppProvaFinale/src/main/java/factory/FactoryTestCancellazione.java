package factory;

import java.util.ArrayList;
import java.util.List;

import core.FactoryInterface;
import core.Test;
import hibernateClasses.tests.TestCancellazioneHibernate;
import jdbcClasses.tests.TestCancellazioneJDBC;

public class FactoryTestCancellazione implements FactoryInterface{

	@Override
	public List<Test> istantiate() {
		List<Test> out = new ArrayList<Test>();
		out.add(new TestCancellazioneHibernate());
		
		out.add(new TestCancellazioneJDBC());
		
		return out;
	}

}
