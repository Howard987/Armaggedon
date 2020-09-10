package model;
import java.util.Date;

import javax.persistence.*;

@Entity(name="project")
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int p_id;
	private String p_name;
	private Date p_start_date;
	private Date p_end_date;
	@Transient
	private int p_cost;
	
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public Date getP_start_date() {
		return p_start_date;
	}
	public void setP_start_date(Date p_start_date) {
		this.p_start_date = p_start_date;
	}
	public Date getP_end_date() {
		return p_end_date;
	}
	public void setP_end_date(Date p_end_date) {
		this.p_end_date = p_end_date;
	}
	public int getP_cost() {
		return p_cost;
	}
	public void setP_cost(int p_cost) {
		this.p_cost = p_cost;
	}

	public Project(String pName, Date pStartDate, Date pEndDate){
		
		this.p_name = pName;
		this.p_start_date = pStartDate;
		this.p_end_date = pEndDate;
		
	}
	

	public Project() {
		
	}
	
	@Override
	public String toString() {
		return "Project [Id: " + p_id + ", Name: " + p_name + ", Start: " + p_start_date + ", End: "
				+ p_end_date + ", Cost: " + p_cost + "]";
	}
	
}
