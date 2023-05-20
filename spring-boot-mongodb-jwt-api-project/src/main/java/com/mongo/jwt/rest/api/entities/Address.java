package com.mongo.jwt.rest.api.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	@Id
	private ObjectId id;
	private String city;
	private String state;
	private String country;
	private Integer pincode;

	public Address(String city, String state, String country, Integer pincode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

}
