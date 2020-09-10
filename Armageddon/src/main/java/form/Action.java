package form;

import java.util.List;
import java.util.Scanner;

import armageddon.Play;
import crud.CrudProject;
import model.Project;

public class Action {
	
	public void actionMenu () {	
		
		int no = 0;
		
		do {	
			Scanner sc = new Scanner(System.in);
			System.out.println("==> Select No: ");
			no = sc.nextInt();
			
			if (no == 1) {
				
				System.out.println("*** CREATE PROJECT ***");
				
				Enco cp = new Enco();
				cp.EncoProject();
				
				Play p = new Play();
				p.menu();
				
			}
		
			if (no == 2) {
				System.out.println("*** CREATE A NEW ACTIVITY ***");
				
				Enco ac = new Enco();
				ac.EncoActivity();
				
				//Enco employee
				
				//Enco timesheet
				
				Play p = new Play();
				p.menu();
			}
		
			if (no == 3) {
				System.out.println("*** DISPLAY PROJECTS AND ACTIVITIES ***");
				
				CrudProject cp = new CrudProject();
				
				List<Project> projectList = cp.readProject();
				for (Project project:projectList){
					
					System.out.println(project);
					}
				
				
				
				Play p = new Play();
				p.menu();
				
			}
		}while(no != 1 && no != 2 && no != 3);	
	}
}
