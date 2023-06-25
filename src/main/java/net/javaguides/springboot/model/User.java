package net.javaguides.springboot.model;

import lombok.Data;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
	private String email;

	private String password;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
	private String idade;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
	private String telefone;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
	private String dataNascimento;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
	private String sexo;

	@NotEmpty(message = "name cannot be empty")
	@NotNull(message = "name cannot be null")
	private String cpf;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	public User() {
	}

	public User(String firstName, String lastName, String email, String password,
				String idade, String telefone, String dataNascimento, String sexo,
				String cpf,	Collection<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.idade = idade;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.roles = roles;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + "]";
	}

}
