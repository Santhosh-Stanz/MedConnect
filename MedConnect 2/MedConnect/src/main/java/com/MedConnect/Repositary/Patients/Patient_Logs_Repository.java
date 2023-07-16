package com.MedConnect.Repositary.Patients;

import com.MedConnect.Models.Patients.Patient_Logs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Patient_Logs_Repository extends MongoRepository<Patient_Logs,String> {
}
