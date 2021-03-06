package com.fdmgroup.pawhero.model;

import java.util.Set;

import javax.persistence.*;

/**
 * The Pet class is part of the model with the following properties:
 * petId, type, name, breed, age, sex, location, adoptionFee,
 * description, and imageUrl. 
 * 
 * @author kentwong
 *
 */
@Entity
@Table(name = "pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private int petId;
	
	private String type;
	private String name;
	private String breed;
	private String age; 
	private String sex;
	private String location;
	
	@Column(name = "adoption_fee")
	private String adoptionFee;
	
	@Column(length = 1000)
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@OneToMany(targetEntity = Application.class, mappedBy = "pet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Application> applications;

	public Pet() {
		super();
	}

	public Pet(String type, String name, String breed, String age, String sex, String location, String adoptionFee,
			String description, String imageUrl) {
		super();
		this.type = type;
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.sex = sex;
		this.location = location;
		this.adoptionFee = adoptionFee;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAdoptionFee() {
		return adoptionFee;
	}

	public void setAdoptionFee(String adoptionFee) {
		this.adoptionFee = adoptionFee;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
