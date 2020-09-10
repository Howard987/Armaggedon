package crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import armageddon.Connection;
import model.Employee;


public class CrudEmployee {

	public void createEmployee (Employee Emp) {	
		
		Connection con = new Connection();
		
		con.getSession().save(Emp);
		
		con.getTransaction().commit();
		
		con.closeConnection();	
	}
	
	public Employee readEmployee (int id) {	
		
		Connection con = new Connection();
		
		Employee emp = con.getSession().get(Employee.class, id);
		
		con.getTransaction().commit();
		
		con.closeConnection();
		
		return emp;	
	}
	
	public List<Employee> readEmployee() {
		
		Connection con = new Connection(); 
		String hql = "from employee";
		Query ask = con.getSession().createQuery(hql);
		List<Employee> employeeList = ask.getResultList();
		
		return employeeList;	
	}
	
	public void updateEmployee (Employee Emp) {	
		
		Connection con = new Connection();
		
		con.getSession().save(Emp);
		
		con.getTransaction().commit();
		
		con.closeConnection();	
	}

}