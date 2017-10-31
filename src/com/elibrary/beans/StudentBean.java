package com.elibrary.beans;

public class StudentBean {
	
	private String firstname,lastname,email,password;
	private String number;
	
	public StudentBean(){ }
	
	public StudentBean(String firstname,String lastname,String email,String password,String number){
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
		this.number=number;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
}
