package neurology.app.model;

import neurology.app.enumerations.Gender;

public class Patient {

	private int id;
	private String firstName;
	private String lastName;
	private String identificationNumber;
	private String dateOfBirth;
	private Gender genderOfPatient;
	private boolean rightHanded;

	public Patient() {

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

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGenderOfPatient() {
		return genderOfPatient;
	}

	public void setGenderOfPatient(Gender genderOfPatient) {
		this.genderOfPatient = genderOfPatient;
	}

	public boolean isRightHanded() {
		return rightHanded;
	}

	public void setRightHanded(boolean rightHanded) {
		this.rightHanded = rightHanded;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}