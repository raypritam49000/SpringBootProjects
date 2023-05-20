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
public class Account {

	@Id
	private ObjectId id;
	private Float total;

	public Account(Float total) {
		super();
		this.total = total;
	}

}
