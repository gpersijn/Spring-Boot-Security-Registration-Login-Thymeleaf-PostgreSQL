package net.javaguides.springboot.controller.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String idade;
	private String telefone;
	private String dataNascimento;
	private String sexo;
	private String cpf;

	public UserRegistrationDto(){}

	public UserRegistrationDto(String firstName, String lastName, String email,
							   String password, String idade, String telefone,
							   String dataNascimento, String sexo, String cpf) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.idade = idade;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.sexo = sexo;
		this.cpf = cpf;
	}
	
}

