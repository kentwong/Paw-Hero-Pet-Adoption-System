package com.fdmgroup.pawhero.model;

import javax.persistence.*;

/**
 * The Application class is part of the model with the following properties: 
 * applicationId, User, message, status, date, and Pet.
 * 
 * @author kentwong
 *
 */
@Entity
@Table(name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private int applicationId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private String message;
	private String status;
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Application() {
		super();
	}

	public Application(User user, String message, String status, String date, Pet pet) {
		super();
		this.user = user;
		this.message = message;
		this.status = status;
		this.pet = pet;
		this.date = date;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
