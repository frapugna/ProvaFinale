package core;

import java.util.List;

public interface UserInterface {
	public String selectTests(String input);
	public void showResult(List<Test> test);
	public boolean askForClose();
}
