package com.mongo.jwt.rest.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.jwt.rest.api.entities.Account;

public interface AccounRepository extends MongoRepository<Account, ObjectId>{

}
