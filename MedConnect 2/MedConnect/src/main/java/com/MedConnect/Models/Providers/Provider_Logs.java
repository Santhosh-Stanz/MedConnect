package com.MedConnect.Models.Providers;

import com.MedConnect.Models.Patients.Patient_Credentials;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "MedConnect_Providers")
public class Provider_Logs {

    private String Id="Provider_Logs";
    private String name;
    private Patient_Credentials patient_credentials;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Patient_Credentials getPatient_credentials() {
        return patient_credentials;
    }

    public void setPatient_credentials(Patient_Credentials patient_credentials) {
        this.patient_credentials = patient_credentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
