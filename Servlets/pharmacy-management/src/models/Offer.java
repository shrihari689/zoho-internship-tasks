package models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Offer {

	private int id;
	private String name;
	private double discount;
	private Timestamp startTime;
	private Timestamp endTime;
	
	public Offer() {}
	
	public Offer(String name, double discount, Timestamp startTime, Timestamp endTime) {
		this.name = name;
		this.discount = discount;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getStartTimeString() {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM YYYY hh:mm a");
		return format.format(this.getStartTime());
	}
	public String getEndTimeString() {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM YYYY hh:mm a");
		return format.format(this.getEndTime());
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
