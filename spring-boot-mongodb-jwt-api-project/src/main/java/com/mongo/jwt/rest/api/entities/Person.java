package com.mongo.jwt.rest.api.entities;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	private ObjectId id;

	@Indexed
	private Integer ssn;

	@DBRef
	private List<Account> accounts;

	@DocumentReference
	private List<Address> addresses;
	
	private Account account;

	public Person(Integer ssn, List<Account> accounts, List<Address> addresses) {
		super();
		this.ssn = ssn;
		this.accounts = accounts;
		this.addresses = addresses;
	}
	
	
	
	

}