package gui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import core.Test;
import core.UserInterface;

public class CLI implements UserInterface{
	
	public String selectTests(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	public void showResult(List<Test> tests) {
		int j = 0;
		System.out.println("--------------------ESITI--------------------");
		for(Test i: tests) {
			
			if((j%4) == 0)
				System.out.println(" ");
			
			System.out.println(i.showResult());
			++j;
		}
		System.out.println("---------------------------------------------");
	}

	public boolean askForClose() {
		System.out.println("Desidera effettuare nuovamente i test?(si/no):");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			s = "no";
		}
		
		if("si".equals(s)) {
			System.out.println("Eseguo nuovamente i test");
			return true;
		}
		else {
			System.out.println("Chiusura appllicazione");
			return false;
		}
	}

}
