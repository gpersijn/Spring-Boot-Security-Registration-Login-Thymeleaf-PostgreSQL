package net.javaguides.springboot.controller;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.controller.dto.UserRegistrationDto;

import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto UserRegistrationDto()
	{
		return new UserRegistrationDto();
	}

	@GetMapping
	public String showRegistrationForm()
	{
		return "registration";
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção ao retornar lista de usuários."),
	})
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto)
	{
		User user = userService.save(registrationDto);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção ao retornar lista de usuários."),
	})
	@PostMapping("/outro")
	@ResponseBody
	public ResponseEntity<?> dregisterUserAccount2(@ModelAttribute("user") UserRegistrationDto registrationDto)
	{
		User user = userService.save(registrationDto);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}


	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de usuários"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso."),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção ao retornar lista de usuários."),
	})
	@GetMapping(value = "/listall")
	@ResponseBody
	public ResponseEntity<List<User>> userList(){
		List<User> users = userRepository.findAll();

		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

}
