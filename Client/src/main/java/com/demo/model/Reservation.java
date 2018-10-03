package com.demo.model;



import java.sql.Date;


public class Reservation {

	
	private Integer reservationId;
	private String firstName;
	private String lastName;
	private Date date;
	private String origin;
	private String destination;
	public Integer getReservationId() {
		return reservationId;
	}
	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Reservation(Integer reservationId, String firstName, String lastName, Date date, String origin,
			String destination) {
		super();
		this.reservationId = reservationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.origin = origin;
		this.destination = destination;
	}
	public Reservation() {}
	
}
