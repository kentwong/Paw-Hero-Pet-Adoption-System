package com.fdmgroup.pawhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/accounts")
	public List<User> getAllPets(){
		return userRepo.findAll();
	}
	
	@PostMapping("/account")
	public User createPet(@RequestBody User user) {
		return userRepo.save(user);
	}
	
//	@PostMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<String> authenticate(@RequestBody User user) {
//		
//		
//	}
}
