package core;

import java.util.ArrayList;
import java.util.List;

public class FactoryManager {
	List<FactoryInterface> factoryList;

	public FactoryManager(List<FactoryInterface> factories) {
		super();
		this.factoryList = factories;
	}
	public List<Test> istantiate(){
		List<Test> out = new ArrayList<Test>();
		
		for(FactoryInterface i: factoryList) {
			out.addAll(i.istantiate());
		}
		
		return out;
	}
	
}
