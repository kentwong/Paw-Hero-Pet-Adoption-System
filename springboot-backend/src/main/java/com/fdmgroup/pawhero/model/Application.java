package com.fdmgroup.pawhero.model;

import javax.persistence.*;

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
	
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Application() {
		super();
	}

	public Application(User user, String message, Pet pet) {
		super();
		this.user = user;
		this.message = message;
		this.pet = pet;
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
}
