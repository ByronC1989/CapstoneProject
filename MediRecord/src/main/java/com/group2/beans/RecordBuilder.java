package com.group2.beans;

import java.sql.Date;

public class RecordBuilder {

	// Adding Builder Pattern to simplify record creation
	
	private String healthCardID;  
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private Date createDate; 	
	private String allergies; 
	private String diagnoses;
	
	public RecordBuilder setHealthCardID(String healthCardID) {
		this.healthCardID = healthCardID;
		return this;
	}
	public RecordBuilder setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public RecordBuilder setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public RecordBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}
	public RecordBuilder setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}
	public RecordBuilder setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}
	public RecordBuilder setAllergies(String allergies) {
		this.allergies = allergies;
		return this;
	}
	public RecordBuilder setDiagnoses(String diagnoses) {
		this.diagnoses = diagnoses;
		return this;
	}
	
	public Record getRecord() {
		return new Record(healthCardID, firstName, lastName, gender, dateOfBirth, allergies, diagnoses, createDate);
	}
	
}
