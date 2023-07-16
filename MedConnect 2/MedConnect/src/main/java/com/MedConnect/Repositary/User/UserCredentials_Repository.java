package com.MedConnect.Repositary.User;

import com.MedConnect.Models.User.UserCredentials;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserCredentials_Repository extends MongoRepository<UserCredentials,String> {
}
