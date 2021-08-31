package com.fdmgroup.pawhero.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.service.UserService;
import com.fdmgroup.pawhero.web.dto.UserRegistrationDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/users")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/signup")
	public String registerUserAcc(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
