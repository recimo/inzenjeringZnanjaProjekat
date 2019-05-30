package neurology.app.model;

import java.sql.Date;

import neurology.app.enumerations.Gender;

public class Patient {

	private String fristName;
	private String lastName;
	private String identificationNumber;
	private Date dateOfBirth;
	private Gender genderOfPatient;
	private Address addressOfPatient;
	private String contactNumber;

	public Patient() {

	}

	public Patient(String fristName, String lastName, String identificationNumber, Date dateOfBirth,
			Gender genderOfPatient, Address addressOfPatient, String contactNumber) {
		this.fristName = fristName;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
		this.dateOfBirth = dateOfBirth;
		this.genderOfPatient = genderOfPatient;
		this.addressOfPatient = addressOfPatient;
		this.contactNumber = contactNumber;
	}

	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGenderOfPatient() {
		return genderOfPatient;
	}

	public void setGenderOfPatient(Gender genderOfPatient) {
		this.genderOfPatient = genderOfPatient;
	}

	public Address getAddressOfPatient() {
		return addressOfPatient;
	}

	public void setAddressOfPatient(Address addressOfPatient) {
		this.addressOfPatient = addressOfPatient;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}