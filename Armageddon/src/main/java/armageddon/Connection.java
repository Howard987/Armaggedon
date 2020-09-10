package armageddon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Activity;
import model.Employee;
import model.Project;
import model.Time;

public class Connection {
	
	private Configuration conf;
	private SessionFactory factory;
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public Transaction getTransaction() {
		return transaction;
	}


	private Transaction transaction;
	
	public void openConnection () {
		
		this.conf = new Configuration().configure()
			.addAnnotatedClass(Project.class)
			.addAnnotatedClass(Activity.class)
			.addAnnotatedClass(Employee.class)
			.addAnnotatedClass(Time.class);
			
		
		this.factory = this.conf.buildSessionFactory();
		this.session = this.factory.openSession();
		
		this.transaction = this.session.beginTransaction();		
	}
	
	public Connection() {
		
		this.openConnection();
	}
	
	
	public void closeConnection () {	
		
		session.close();
	}

}
