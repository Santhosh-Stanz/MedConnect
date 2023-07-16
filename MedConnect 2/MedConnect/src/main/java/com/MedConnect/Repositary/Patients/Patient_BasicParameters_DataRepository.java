package com.MedConnect.Repositary.Patients;

import com.MedConnect.Models.Patients.Patient_BasicParameters;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Patient_BasicParameters_DataRepository extends MongoRepository<Patient_BasicParameters,String> {
}
