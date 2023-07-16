package com.MedConnect.Repositary.Providers;

import com.MedConnect.Models.Providers.Provider_Logs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Provider_Logs_Repository extends MongoRepository<Provider_Logs,String> {
}
