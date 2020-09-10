package crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import armageddon.Connection;
import model.Activity;

public class CrudActivity {
	
	public void createActivity (Activity Act) {	
		
		Connection con = new Connection();
		
		con.getSession().save(Act);
		
		con.getTransaction().commit();
		
		con.closeConnection();	
	}
	
	public Activity readActivity (int id) {	
		
		Connection con = new Connection();
		
		Activity act = con.getSession().get(Activity.class, id);
		
		con.getTransaction().commit();
		
		con.closeConnection();
		
		return act;	
	}
	
	public List<Activity> readActivity() {
		
		Connection con = new Connection(); 
		String hql = "from activity";
		Query ask = con.getSession().createQuery(hql);
		List<Activity> activitytList = ask.getResultList();
		
		return activitytList;	
	}
	
}
