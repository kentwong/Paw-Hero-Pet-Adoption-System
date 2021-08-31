package com.fdmgroup.pawhero;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fdmgroup.pawhero.model.Role;
import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.repositories.RoleRepository;
import com.fdmgroup.pawhero.repositories.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Preload role, admin, and user account
		// username: admin, password: admin
		// username: user, password: user
		Role admin = new Role(1, "admin");
		Role user = new Role(2, "user");
		
		roleRepo.save(admin);
		roleRepo.save(user);
		
		userRepo.save(new User(1, Arrays.asList(admin), "admin", "admin", "0488888888", "admin@pawhero.com.au", "admin"));
		userRepo.save(new User(2, Arrays.asList(user), "user", "user", "0499999999", "user@user.com", "user"));
	}

}
