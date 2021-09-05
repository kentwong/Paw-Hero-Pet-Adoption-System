package com.fdmgroup.pawhero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.exception.ResourceNotFoundException;
import com.fdmgroup.pawhero.model.Application;
import com.fdmgroup.pawhero.repositories.ApplicationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/application")
public class ApplicationController {

	private static Logger logger = LogManager.getLogger(ApplicationController.class); 
	
	@Autowired
	ApplicationRepository applicationRepo;
	
	public ApplicationController(ApplicationRepository applicationRepo) {
		super();
		this.applicationRepo = applicationRepo;
	}

	@GetMapping("/all")
	public List<Application> getAllApplications(){
		logger.info("GET request for /all");
		return applicationRepo.findAll();
	}
	
	@PostMapping("/create")
	public Application createApplication(@RequestBody Application app) {
		logger.info("POST request for /create");
		return applicationRepo.save(app);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Application> updateApplication(@PathVariable Integer id, @RequestBody Application applicationUpdates) {
		logger.info("PUT request for /update/" + id.toString());
		Application application = applicationRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Application does not exist with id : " + id));
		
		application.setStatus(applicationUpdates.getStatus());
		
		
		Application updatedApplication = applicationRepo.save(application);
		return ResponseEntity.ok(updatedApplication);
	}
	
	@GetMapping("/all/{userId}")
	public ResponseEntity<List<Application>> getAllApplicationsByUserId(@PathVariable String userId) {
		logger.info("GET request for /all/" + userId.toString());
		List<Application> applications = applicationRepo.findAllByUserId(userId);
				
		return ResponseEntity.ok(applications);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteApplication(@PathVariable Integer id) {
		logger.info("DELETE request for /delete/" + id.toString());
		Application application = applicationRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Application does not exist with id : " + id));
		
		applicationRepo.delete(application);
	
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
}
