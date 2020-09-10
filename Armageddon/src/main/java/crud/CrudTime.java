package crud;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import armageddon.Connection;
import model.Time;

public class CrudTime {

	public void createTime (Time Hour) {	
		
		Connection con = new Connection();
		
		con.getSession().save(Hour);
		
		con.getTransaction().commit();
		
		con.closeConnection();	
	}
	
	public Time readTime (int id) {	
		
		Connection con = new Connection();
		
		Time hour = con.getSession().get(Time.class, id);
		
		con.getTransaction().commit();
		
		con.closeConnection();
		
		return hour;	
	}
	
	public List<Time> readTime() {
		
		Connection con = new Connection(); 
		String hql = "from time";
		Query ask = con.getSession().createQuery(hql);
		List<Time> timeList = ask.getResultList();
		
		return timeList;	
	}

}
