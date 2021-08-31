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
		// Preload role and admin account
		// username: admin
		// password: admin
		Role admin = new Role(1, "admin");
		
		roleRepo.save(admin);
		roleRepo.save(new Role(2, "user"));
		
		userRepo.save(new User(1, Arrays.asList(admin), "admin", "admin", "0488888888", "admin@pawhero.com.au", "admin"));
	}

}
