package form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import armageddon.Play;
import crud.CrudActivity;
import crud.CrudEmployee;
import crud.CrudProject;
import crud.CrudTime;
import model.Activity;
import model.Employee;
import model.Project;
import model.Time;

public class Enco {

	public void EncoProject () {	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==> Project name: ");
		String pName = sc.nextLine();
		
		try {
		
			Scanner sc2 = new Scanner(System.in);
			System.out.println("==> Start date: ");
			Date pStartDate;
		
			pStartDate = new SimpleDateFormat("yyyy/MM/dd").parse(sc2.nextLine());
			
			Scanner sc3 = new Scanner(System.in);
			System.out.println("==> End date: ");
			Date pEndDate = new SimpleDateFormat("yyyy/MM/dd").parse(sc3.nextLine());
			
			Project project = new Project(pName, pStartDate, pEndDate);
			
			CrudProject cp = new CrudProject();
			cp.createProject(project);
			
		} catch (ParseException excep) {
			excep.printStackTrace();
		}
	}
		
	public void EncoActivity () {	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("==> Project no: ");
		int fkProject = sc.nextInt();			
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("==> Activity description: ");
		String aDescription = sc2.nextLine();
			
		Activity activity = new Activity(fkProject, aDescription);
		
		System.out.println("1 --> Create a new employee");
		System.out.println("2 --> Select an employee");
		
		Scanner empChoice = new Scanner(System.in);
		System.out.println("==> Select No: ");
		int no = empChoice.nextInt();
		
		do{
			if (no == 1) {
				
				System.out.println("*** CREATE A NEW EMPLOYEE ***");
			
				Scanner sc3 = new Scanner(System.in);
				System.out.println("==> Employee name: ");
				String empName = sc3.nextLine();
			
				Employee employee = new Employee(empName);
				
				CrudEmployee ce = new CrudEmployee();
				ce.createEmployee(employee);
			}
			
			if (no == 2) {
				
				System.out.println("*** Employee list ***");
			
				CrudEmployee ce = new CrudEmployee();
				
				List<Employee> employeetList = ce.readEmployee();
				for (Employee employee:employeetList){
					
					System.out.println(employee);
					}
				
				
				Scanner scNo = new Scanner(System.in);
				System.out.println("==> Select employee No: ");
				int empNo = scNo.nextInt();
			
			}
		
		}while(no != 1 && no != 2);
			
		//Enco time
		Scanner sc4 = new Scanner(System.in);
		System.out.println("==> Hour: ");
		int tHour = sc4.nextInt();
		
		Scanner sc5 = new Scanner(System.in);
		System.out.println("==> Cost: ");
		int tCost = sc5.nextInt();
		
		Time time = new Time(tHour, tCost);
			
		//Save in database
		CrudTime ct = new CrudTime();
		ct.createTime(time);
		
		//CrudEmployee ce = new CrudEmployee();
		//ce.createEmployee(employee);

		CrudActivity ca = new CrudActivity();
		ca.createActivity(activity);	
	}
}
