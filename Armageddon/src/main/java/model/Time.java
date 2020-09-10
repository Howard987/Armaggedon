package model;

import javax.persistence.*;

@Entity(name="time")
@Table(name="time")
public class Time {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int t_id;
	private int t_a_fk;
	private int t_hour;
	private int t_cost;
	
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getT_a_fk() {
		return t_a_fk;
	}
	public void setT_a_fk(int t_a_fk) {
		this.t_a_fk = t_a_fk;
	}
	public int getT_hour() {
		return t_hour;
	}
	public void setT_hour(int t_hour) {
		this.t_hour = t_hour;
	}
	public int getT_cost() {
		return t_cost;
	}
	public void setT_cost(int t_cost) {
		this.t_cost = t_cost;
	}
	
	public Time(int tHour, int tCost){
		
		this.t_a_fk = 1;
		this.t_hour = tHour;
		this.t_cost = tCost;
		
	}
	

	public Time() {
		
	}
	@Override
	public String toString() {
		return "Time [Id: " + t_id + ", Hour: " + t_hour + ", Cost: " + t_cost + "]";
	}
}
