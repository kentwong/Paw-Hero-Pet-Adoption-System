package com.fdmgroup.pawhero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fdmgroup.pawhero.model.Role;
import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.repositories.RoleRepository;
import com.fdmgroup.pawhero.repositories.UserRepository;

/**
 * Run this class to get started.
 * 
 * @author kentwong
 *
 */
@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	/**
	 *  Preload role, admin, and user account
	 *  email: admin@admin.com, password: admin
	 *  email: user@user.com, password: user
	 */
	@Override
	public void run(String... args) throws Exception {

		Role admin = new Role(1, "admin");
		Role user = new Role(2, "user");
		
		roleRepo.save(admin);
		roleRepo.save(user);
		
		userRepo.save(new User(1, admin, "Admin", "Admin", "0488888888", "admin@admin.com", "admin"));
		userRepo.save(new User(2, user, "Kent", "Wong", "0499999999", "user@user.com", "user"));
	}
}
