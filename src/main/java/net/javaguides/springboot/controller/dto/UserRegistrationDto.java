package net.javaguides.springboot.controller.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private String dateOfBirth;
	private String sex;
	private String cpf;

	public UserRegistrationDto(){}

	public UserRegistrationDto(String firstName, String lastName, String email,
							   String password, String phone,
							   String dateOfBirth, String sex, String cpf) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.sex = sex;
		this.cpf = cpf;
	}
	
}

