package com.MedConnect.Repositary.Patients;

import com.MedConnect.Models.Patients.Patient_HealthParameters;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Patient_HealthParameters_Repository extends MongoRepository<Patient_HealthParameters,String> {
}
