package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Person {

	public Person(int personId, String email, String firstName, String lastName, int age, String gender) {
		super();
		this.personId = personId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personId;
	
//	@ValidEmail(min = 10, message = "Please enter a valid email.")
	private String email;
	
	@Size( min=1,max=20,message="please enter the personname within the range")
	private String firstName;
	private String lastName;
	
	private int age;
	
	private Health health;//good or bad
	
	public Health getHealth() {
		return health;
	}
	public void setHealth(Health health) {
		this.health = health;
	}
	private String suggestDoctor;//mandatory when heath is bad and optional when health is good(can send null)
	public String getSuggestDoctor() {
		return suggestDoctor;
	}
	public void setSuggestDoctor(String suggestDoctor) {
		this.suggestDoctor = suggestDoctor;
	}
	private String gender;
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public static enum Health {
		bad, good;
	}
	
	 
}
