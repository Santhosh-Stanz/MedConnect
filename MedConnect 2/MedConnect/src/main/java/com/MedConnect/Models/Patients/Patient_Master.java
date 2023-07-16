package com.MedConnect.Models.Patients;

import org.springframework.stereotype.Component;

@Component
public class Patient_Master {

    private Patient_BasicParameters patient_basicParameters;
    private Patient_Credentials patient_credentials;
    private Patient_HealthParameters patientHealthParameters;

    public Patient_BasicParameters getPatient_basicParameters() {
        return patient_basicParameters;
    }

    public void setPatient_basicParameters(Patient_BasicParameters patient_basicParameters) {
        this.patient_basicParameters = patient_basicParameters;
    }

    public void setPatient_credentials(Patient_Credentials patient_credentials) {
        this.patient_credentials = patient_credentials;
    }

    public Patient_Credentials getPatient_credentials() {
        return patient_credentials;
    }

    public Patient_HealthParameters getPatientHealthParameters() {
        return patientHealthParameters;
    }

    public void setPatientHealthParameters(Patient_HealthParameters patientHealthParameters) {
        this.patientHealthParameters = patientHealthParameters;
    }
}
