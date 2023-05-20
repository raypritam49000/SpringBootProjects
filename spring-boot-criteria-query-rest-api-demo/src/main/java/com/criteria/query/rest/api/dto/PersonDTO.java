package com.criteria.query.rest.api.dto;

public class PersonDTO {
	private String id;
	private String username;
	private String email;
	private String password;
	private String city;
	
	public PersonDTO() {
		super();
	}

	public PersonDTO(String username, String email, String password, String city) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "PersonDTO [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", city=" + city + "]";
	}

	
}
