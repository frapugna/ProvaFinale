package core;

import java.util.List;

public class TestManager {
	List<Test> tests;
	UserInterface gui;
	
	public TestManager(List<Test> tests, UserInterface gui) {
		super();
		this.tests = tests;
		this.gui = gui;
	}
	
	public void selectTests() {
		
	}
	
	public void runAll() {
		for(Test i:tests)
			i.run();
	}
	
	public void displayAllResults() {
		gui.showResult(tests);
	}
	
	public boolean askForClose() {
		return gui.askForClose();
	}

}
