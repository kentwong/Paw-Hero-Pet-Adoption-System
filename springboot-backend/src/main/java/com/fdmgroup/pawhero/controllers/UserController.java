package com.fdmgroup.pawhero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * The UserController class controls the flow of data into model object. The 
 * rest API requests available include getAllUsers(), createUser(),
 * getUserByEmail(), getUserById(), updateUser() and deleteUser(). 
 * 
 * @author kentwong
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/user")
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	public UserController(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	/**
	 * The getAllUsers method return the list of all User objects.
	 * 
	 * @return List of User Objects
	 */
	@GetMapping("/accounts")
	public List<User> getAllUsers(){
		logger.info("GET request for /accounts");
		return userRepo.findAll();
	}
	
	/**
	 * The createUser method will save the new User in the database
	 * 
	 * @param user New User's object
	 * @return User object
	 */
	@PostMapping("/account")
	public User createUser(@RequestBody User user) {
		logger.info("POST request for /accounts");
		return userRepo.save(user);
	}
	
	/**
	 * The getUserByEmail will return the User with the email specified in the 
	 * path variable
	 * 
	 * @param email User's email
	 * @return Response Entity of User
	 */
	@GetMapping("/auth/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
		logger.info("GET request for /auth/" + email);
		User user = userRepo.findByEmail(email);
				
		return ResponseEntity.ok(user);
	}
	
	/**
	 * The getUserById will return the User with ID specified in the path
	 * variable.
	 * 
	 * @param id
	 * @return ReponseEntity of User
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		logger.info("GET request for /" + id.toString());
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id : " + id));
		
		return ResponseEntity.ok(user);
	}
	
	/**
	 * The updateUser method will update the properties of the user with ID specified in 
	 * the path variable
	 * 
	 * @param id User's ID
	 * @param userUpdates User with updated properties
	 * @return ResponseEntity of User
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userUpdates) {
		logger.info("PUT request for /" + id.toString());
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
	
	/**
	 * The deleteUser method delete the User with the specified id in
	 * the path variable. 
	 * 
	 * @param id User's ID
	 * @return ResponseEntity of Map stating if deleted is true
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id) {
		logger.info("DELETE request for /" + id.toString());
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User does not exist with id : " + id));
		
		userRepo.delete(user);
	
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
}
