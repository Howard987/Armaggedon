package crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import armageddon.Connection;
import model.Project;


public class CrudProject {

	public void createProject (Project proj) {	
		
		Connection con = new Connection();
		
		con.getSession().save(proj);
		
		con.getTransaction().commit();
		
		con.closeConnection();	
	}
	
	public Project readProject (int id) {	
		
		Connection con = new Connection();
		
		Project proj = con.getSession().get(Project.class, id);
		
		con.getTransaction().commit();
		
		con.closeConnection();
		
		return proj;	
	}
	
	public List<Project> readProject() {
		
		Connection con = new Connection(); 
		String hql = "from project";
		Query ask = con.getSession().createQuery(hql);
		List<Project> projectList = ask.getResultList();
		
		return projectList;	
	}

}
