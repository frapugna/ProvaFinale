package core;

import antlr.collections.List;

public interface UserInterface {
	public String selectTests(String input);
	public void showResult(List test);
	public boolean askForClose();
}
