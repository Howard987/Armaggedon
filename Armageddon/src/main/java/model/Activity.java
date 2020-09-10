package model;
import javax.persistence.*;



@Entity(name="activity")
@Table(name="activity")
public class Activity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int a_id;
	private int a_e_fk;
	private int a_p_fk;
	private String a_description;
	private int a_cost;
	
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public int getA_e_fk() {
		return a_e_fk;
	}
	public void setA_e_fk(int a_e_fk) {
		this.a_e_fk = a_e_fk;
	}
	public int getA_p_fk() {
		return a_p_fk;
	}
	public void setA_p_fk(int a_p_fk) {
		this.a_p_fk = a_p_fk;
	}
	public String getA_description() {
		return a_description;
	}
	public void setA_description(String a_description) {
		this.a_description = a_description;
	}
	public int getA_cost() {
		return a_cost;
	}
	public void setA_cost(int a_cost) {
		this.a_cost = a_cost;
	}

	public Activity(int fkProject, String aDescription){
		
		this.a_p_fk = fkProject;
		this.a_description = aDescription;
		this.a_e_fk = 1;
	}
	
	public Activity() {
		
	}
	
	@Override
	public String toString() {
		return "Activity [Id: " + a_id + ", Description: " + a_description + ", Cost: " + a_cost + "]";
	}
	
}
