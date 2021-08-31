package com.fdmgroup.pawhero.web.dto;

public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String phone;
	private String emailAddress;
	private String password;
	
	public UserRegistrationDto(String firstName, String lastName, String phone, String emailAddress, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.emailAddress = emailAddress;
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
