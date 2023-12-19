package com.group2.beans;

import java.sql.Date;

public class Record {
	
	// recorder identifiers 
	private String healthCardID;  // Is a unique 10 digit number to identify each post.
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private Date createDate; // create date in sql format and pass it into the record class?
	
	private String allergies; // change to array of strings?
	private String diagnoses;
	
	
	// constructor for entering new patient with no diagnoses, or allergy information
	public Record(String healthCardID, String firstName, String lastName, String gender, String dateOfBirth, Date createDate) {
		this.healthCardID = healthCardID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.createDate = createDate;
		
	}
	
	// constructor for entering patient with no allergies.
	public Record(String healthCardID, String firstName, String lastName, String gender, String dateOfBirth, String diagnoses, Date createDate) {
		this.healthCardID = healthCardID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.diagnoses = diagnoses;
		this.createDate = createDate;
		
	}
	
	// constructor for entering patient with allergies and diagnoses
	public Record(String healthCardID, String firstName, String lastName, String gender, String dateOfBirth, String allergies, String diagnoses, Date createDate) {
		this.healthCardID = healthCardID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.diagnoses = diagnoses;
		this.createDate = createDate;
		
	}
	
	
	// Getters and Setters for Record Class
	public String getHealthCardID() {
		return healthCardID;
	}

	public void setHealthCardID(String healthCardID) {
		this.healthCardID = healthCardID;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getDiagnoses() {
		return diagnoses;
	}

	public void setDiagnoses(String diagnoses) {
		this.diagnoses = diagnoses;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
