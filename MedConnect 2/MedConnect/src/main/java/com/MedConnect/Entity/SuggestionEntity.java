package com.MedConnect.Entity;

import com.MedConnect.Models.Patients.Patient_BasicParameters;
import com.MedConnect.Models.Patients.Patient_HealthParameters;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuggestionEntity {

    private List<String> suggesstionlist;
    private Patient_HealthParameters patientHealthParameters;
    private Patient_BasicParameters patientBasicParameters;

    public List<String> getSuggesstionlist() {
        return suggesstionlist;
    }

    public Patient_BasicParameters getPatientBasicParameters() {
        return patientBasicParameters;
    }

    public Patient_HealthParameters getPatientHealthParameters() {
        return patientHealthParameters;
    }

    public void setPatientBasicParameters(Patient_BasicParameters patientBasicParameters) {
        this.patientBasicParameters = patientBasicParameters;
    }

    public void setPatientHealthParameters(Patient_HealthParameters patientHealthParameters) {
        this.patientHealthParameters = patientHealthParameters;
    }

    public void setSuggesstionlist(List<String> suggesstionlist) {
        this.suggesstionlist = suggesstionlist;
    }
}
