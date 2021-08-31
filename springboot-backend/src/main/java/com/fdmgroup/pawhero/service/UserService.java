package com.fdmgroup.pawhero.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.pawhero.model.Role;
import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.repositories.UserRepository;
import com.fdmgroup.pawhero.web.dto.UserRegistrationDto;

@Service
public class UserService implements IUserService {

	private UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
		
		User user = new User(
				Arrays.asList(new Role("ROLE_USER")),
				registrationDto.getFirstName(),
				registrationDto.getLastName(),
				registrationDto.getPhone(),
				registrationDto.getEmailAddress(),
				registrationDto.getPassword()
				);
		
		return userRepo.save(user);
	}
}
