package com.MedConnect.Repositary.Patients;

import com.MedConnect.Models.Patients.Patient_Diseases;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Patient_Diseases_Repository extends MongoRepository<Patient_Diseases,String> {
}
