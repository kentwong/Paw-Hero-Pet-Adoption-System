package com.fdmgroup.pawhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.exception.ResourceNotFoundException;
import com.fdmgroup.pawhero.model.Application;
import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.repositories.ApplicationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/application")
public class ApplicationController {

	@Autowired
	ApplicationRepository applicationRepo;
	
	@GetMapping("/all")
	public List<Application> getAllApplications(){
		return applicationRepo.findAll();
	}
	
//	@GetMapping("/all/{id}")
//	public ResponseEntity<List<Application>> getApplicationsById(@PathVariable Integer id) {
//		List<Application> application = applicationRepo.findAllById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Pet does not exist with id : " + id));
//		
//		return ResponseEntity.ok(application);
//	}
	
	@PostMapping("/create")
	public Application createApplication(@RequestBody Application app) {
		return applicationRepo.save(app);
	}
}
