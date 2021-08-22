package com.fdmgroup.pawhero.model;

import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id")
	private int applicationId;
	
	@Column(name = "user_id")
	private int userId;
	
	private String message;
	
	@Column(name = "pet_id")
	private String petId;

	public Application() {
		super();
	}

	public Application(int userId, String message, String petId) {
		super();
		this.userId = userId;
		this.message = message;
		this.petId = petId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}
}
