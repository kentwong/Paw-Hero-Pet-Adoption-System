package com.fdmgroup.pawhero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.exception.ResourceNotFoundException;
import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@GetMapping("/accounts")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@PostMapping("/account")
	public User createUser(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	@GetMapping("/auth/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		User user = userRepo.findByEmail(email);
				
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id : " + id));
		
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userUpdates) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id : " + id));
		
		user.setEmailAddress(userUpdates.getEmailAddress());
		user.setFirstName(userUpdates.getFirstName());
		user.setLastName(userUpdates.getLastName());
		user.setPhone(userUpdates.getPhone());
		user.setPassword(userUpdates.getPassword());

		User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id : " + id));
		
		userRepo.delete(user);
	
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
}
