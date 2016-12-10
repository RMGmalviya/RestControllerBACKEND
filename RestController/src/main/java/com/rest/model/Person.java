package com.rest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="personinfo")
public class Person {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	
	private int personId;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	@Length(min=10,max=10)
	private String phoneno;
	private Date dob;
	public int getPersonId() {
		return personId;
	}
	public void setPersonID(int personID) {
		this.personId = personID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	

}
