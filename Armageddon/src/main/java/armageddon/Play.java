package armageddon;

import form.Action;

public class Play {

	public void menu () {	
		
		System.out.println("ARMAGEDDON - MAIN MENU");
		System.out.println("1 --> Create a new project");
		System.out.println("2 --> Create a new activity");
		System.out.println("3 --> Display projects and activites");
		
		Action a = new Action();
		a.actionMenu();
	}
}
