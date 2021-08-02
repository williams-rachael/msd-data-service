package com.bah.msd.domain;

import java.util.Date;

public class Registration {
	
	long id;
	int event_id;
	int customer_id;
	Date registration_date;
	String notes;

	public Registration() {
		// TODO Auto-generated constructor stub
	}
	
	public Registration(long id, int event_id, int customer_id, Date registration_date, String notes) {
		super();
		this.id = id;
		this.event_id = event_id;
		this.customer_id = customer_id;
		this.registration_date = registration_date;
		this.notes = notes;
	}
	
	public String toJSON() {
		return "{\"id:\"" + id + ", \"event_id:\"" + event_id + ", \"customer_id:\"" + customer_id 
				+ ", \"registration_date:\"" + registration_date + ", \"notes:\"" + notes + " }";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public Date getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	

}
