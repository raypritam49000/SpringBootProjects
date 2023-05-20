package com.mongo.jwt.rest.api.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.jwt.rest.api.entities.Address;

public interface AddressRepository extends MongoRepository<Address, ObjectId>{

}
