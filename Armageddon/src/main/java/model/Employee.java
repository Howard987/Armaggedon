package model;

import javax.persistence.*;

@Entity(name="employee")
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int e_id;
	private String e_name;
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	
	public Employee(String eName){
		
		this.e_name = eName;

	}
	

	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [Id: " + e_id + ", Name: " + e_name + "]";
	}
	
}
