package neurology.app.controller;

import neurology.app.controller.dataBase.patient.InsertPatient;
import neurology.app.enumerations.Gender;
import neurology.app.model.Patient;

public class PatientCreateAction {

	public void action(Patient newPatient, String firstName, String lastName, String id, String date, String gender,
			boolean rightHand) {
		newPatient.setFirstName(firstName);
		newPatient.setLastName(lastName);
		newPatient.setIdentificationNumber(id);
		newPatient.setDateOfBirth(date);
		newPatient.setRightHanded(rightHand);

		if (gender.equals(Gender.Male.toString())) {
			newPatient.setGenderOfPatient(Gender.Male);
		} else {
			newPatient.setGenderOfPatient(Gender.Female);
		}

		InsertPatient insert = new InsertPatient(newPatient);

		try {
			insert.insert();
		} catch (Exception e) {
			System.out.println("NECE DA GA UPISE!");
			e.printStackTrace();
		}

	}

}
