package com.fdmgroup.pawhero.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.pawhero.service.UserService;
import com.fdmgroup.pawhero.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	public String registerUserAcc(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
