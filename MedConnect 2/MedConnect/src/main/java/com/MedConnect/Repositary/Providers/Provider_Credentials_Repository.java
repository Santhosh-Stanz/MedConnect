package com.MedConnect.Repositary.Providers;

import com.MedConnect.Models.Providers.Provider_Credentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Provider_Credentials_Repository extends MongoRepository<Provider_Credentials,String> {
}
