package com.fdmgroup.pawhero.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.pawhero.model.Role;
import com.fdmgroup.pawhero.model.User;


@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	@Mock
	private RoleRepository mockRoleRepo;
	
	@Mock
	private User mockUser;
	
	@Mock
	private Role mockRole;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void that_findByEmail_returnsUserWithThatEmail() {
		
//		String email = "user@user.com";
//		mockRole = new Role(1, "user");
//		mockRoleRepo.save(mockRole);
//		userRepo.save(new User(1, mockRole, "Kent", "Wong", "0499999999", email, "user"));
//	
//		User user = userRepo.findByEmail(email);
//		
//		assertEquals("user",user);
		
	}

}
