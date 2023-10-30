package serrano.mercedes.taller.view;

import java.util.Scanner;

public class BaseConsoleView {

	public void mostraMissatge(String missatge, boolean isError) {
	
		if(isError) {
			System.err.println(missatge);
		}else {
			System.out.println(missatge);
		}
	}
	
	public int getInt(String missatge) {
		int resultat = 0;
		System.out.println(missatge);
		Scanner scanner = new Scanner(System.in);
		resultat = scanner.nextInt();
		
		return resultat;
	}
	
	public String getString(String missatge) {
		String resultat = "";
		System.out.println(missatge);
		Scanner scanner = new Scanner(System.in);
		resultat = scanner.nextLine();
		
		return resultat;
	}
}
