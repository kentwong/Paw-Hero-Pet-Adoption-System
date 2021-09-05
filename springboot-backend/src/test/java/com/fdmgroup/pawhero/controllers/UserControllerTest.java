package com.fdmgroup.pawhero.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.fdmgroup.pawhero.exception.ResourceNotFoundException;
import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	private UserRepository mockUserRepo;
	
	private UserController userController;
	
	@BeforeEach
	void setUp() throws Exception {
		userController = new UserController(mockUserRepo);
	}

	@Test
	void that_getAllUsers_returnsAllUsers() {
		List<User> users = Arrays.asList(new User());
		when(mockUserRepo.findAll()).thenReturn(users);
		
		List<User> foundUsers = userController.getAllUsers();
		
		verify(mockUserRepo).findAll();
		assertEquals(users, foundUsers);
	}
	
	@Test
	void that_createUser_saveUser_and_returnsUser() {
		User user = new User();
		when(mockUserRepo.save(user)).thenReturn(user);
		
		User createdUser = userController.createUser(user);
		
		verify(mockUserRepo).save(user);
		assertEquals(user, createdUser);
	}
	
	@Test
	void that_getUserByEmail_findUser_and_returnUser() {
		String email = "test@test.com";
		User user = new User();
		when(mockUserRepo.findByEmail(email)).thenReturn(user);
		
		ResponseEntity<User> foundUser = userController.getUserByEmail(email);
		
		verify(mockUserRepo).findByEmail(email);
		assertEquals(200, foundUser.getStatusCodeValue());
		assertEquals(user, foundUser.getBody());
	}
	
	@Test
	void that_getUserById_findById_and_returnUser() {
		User user = new User();
		Optional<User> ofResult = Optional.of(user);
		int id = 1;
		when(mockUserRepo.findById(id)).thenReturn(ofResult);
		
		ResponseEntity<User> foundUser = userController.getUserById(id);
		
		verify(mockUserRepo).findById(id);
		assertEquals(200, foundUser.getStatusCodeValue());
		assertEquals(user, foundUser.getBody());
	}
	
	@Test
	void that_getUserById_findById_and_returnResourceNotFoundException() {
		
		int id = 1;
		when(mockUserRepo.findById(id)).thenReturn(Optional.<User>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> userController.getUserById(id)); 
		assertEquals("User does not exist with id : 1", thrown.getMessage());
	}
	
	
	@Test
	void that_updateUser_findById_and_saveUser_and_returnUser() {
		
		User user = new User();
		Optional<User> ofResult = Optional.of(user);
		int id = 1;
		when(mockUserRepo.findById(id)).thenReturn(ofResult);
	
		ResponseEntity<User> updatedUser = userController.updateUser(id, user);
		
		verify(mockUserRepo).findById(id);
		verify(mockUserRepo).save(user);
		assertEquals(200, updatedUser.getStatusCodeValue());
	}
	
	@Test
	void that_updateUser_findById_and_returnResourceNotFoundException() {
		int id = 2;
		User user = new User();
		when(mockUserRepo.findById(id)).thenReturn(Optional.<User>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> userController.updateUser(id, user)); 
		assertEquals("User does not exist with id : 2", thrown.getMessage());
	}
	
	@Test
	void that_deleteUser_findById_and_deleteUser_and_returnResponseEntity() {
		User user = new User();
		Optional<User> ofResult = Optional.of(user);
		int id = 3;
		when(mockUserRepo.findById(id)).thenReturn(ofResult);
		
		ResponseEntity<Map<String, Boolean>> deletedMessage = userController.deleteUser(id);
		
		verify(mockUserRepo).findById(id);
		verify(mockUserRepo).delete(user);
		
		assertEquals(200, deletedMessage.getStatusCodeValue());
		assertEquals("{deleted=true}", deletedMessage.getBody().toString());
	}
	
	@Test
	void that_deleteUser_findById_and_returnResourceNotFoundException() {
		int id = 4;
		when(mockUserRepo.findById(id)).thenReturn(Optional.<User>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> userController.deleteUser(id)); 
		assertEquals("User does not exist with id : 4", thrown.getMessage());
	}
}
