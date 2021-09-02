package com.fdmgroup.pawhero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.model.Application;
import com.fdmgroup.pawhero.repositories.ApplicationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/application")
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepo;
	
	@PostMapping("/application")
	public Application createApplication(@RequestBody Application app) {
		return applicationRepo.save(app);
	}
}
