package com.MedConnect.Repositary.Patients;

import com.MedConnect.Models.Patients.Patient_Credentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Patient_Credentials_DataRepository extends MongoRepository<Patient_Credentials,String>{
}
