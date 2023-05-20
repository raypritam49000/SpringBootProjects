package com.mongo.jwt.rest.api;

import java.util.List;

import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongo.jwt.rest.api.entities.Account;
import com.mongo.jwt.rest.api.entities.Address;
import com.mongo.jwt.rest.api.entities.Person;
import com.mongo.jwt.rest.api.repository.PersonRepository;

@SpringBootApplication
public class SpringBootMongodbJwtApiProjectApplication {
	
	@Autowired
	private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbJwtApiProjectApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("@@@@ init Method");
		
		List<Account> accList = List.of(new Account(new ObjectId(),240F),new Account(new ObjectId(),500F));
		List<Address> addList = List.of(new Address(new ObjectId(),"Prem Nagar","Punjab","India",144533),new Address(new ObjectId(),"Ropar","Punjab","India",140001));
		
		Person person = new Person();
		person.setId(new ObjectId());
		person.setAccounts(accList);
		person.setAddresses(addList);
		person.setSsn(200);
		person.setAccount(new Account(new ObjectId(),240F));
		
		Person createdPerson = personRepository.save(person);
		System.out.println(createdPerson);
		System.out.println(createdPerson.getAccounts());
		System.out.println(createdPerson.getAddresses());
		System.out.println(createdPerson.getAccount());
		
		
	
		
	}

}
