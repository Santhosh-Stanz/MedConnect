package com.MedConnect.Models.Patients;

import com.MedConnect.Models.Providers.Provider_Credentials;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Document(collection = "MedConnect_patient")
public class Patient_Logs {

    private String id="Patient_Logs";
    private String name;
    private Provider_Credentials providerCredentials;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Provider_Credentials getProviderCredentials() {
        return providerCredentials;
    }

    public void setProviderCredentials(Provider_Credentials providerCredentials) {
        this.providerCredentials = providerCredentials;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
