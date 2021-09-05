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

/**
 * The ApplicationController class controls the flow of data into model object. The 
 * rest API requests available include getAllApplications(), createApplication(),
 * updateApplication(), getAllApplicationsByUserId() and deleteApplication(). 
 * 
 * @author kentwong
 *
 */
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

	/**
	 * The getAllApplications method return the list of all Application objects.
	 * 
	 * @return List of Application Objects
	 */
	@GetMapping("/all")
	public List<Application> getAllApplications(){
		logger.info("GET request for /all");
		return applicationRepo.findAll();
	}
	
	/**
	 * The createApplication method will save the new Application in the database
	 * 
	 * @param app New Application's object
	 * @return Application object
	 */
	@PostMapping("/create")
	public Application createApplication(@RequestBody Application app) {
		logger.info("POST request for /create");
		return applicationRepo.save(app);
	}
	
	/**
	 * The updateApplication method will update the status of the application with ID
	 * specified in path variable. 
	 * 
	 * @param id Application's ID
	 * @param applicationUpdates Updated application details
	 * @return ResponseEntity of Application
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Application> updateApplication(@PathVariable Integer id, @RequestBody Application applicationUpdates) {
		logger.info("PUT request for /update/" + id.toString());
		Application application = applicationRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Application does not exist with id : " + id));
		
		application.setStatus(applicationUpdates.getStatus());
		
		
		Application updatedApplication = applicationRepo.save(application);
		return ResponseEntity.ok(updatedApplication);
	}
	
	/**
	 * The getAllApplicationsByUserId method returns all applications with the specified
	 * user ID in path variable. 
	 * 
	 * @param userId User's ID
	 * @return ResponseEntity of List of Application
	 */
	@GetMapping("/all/{userId}")
	public ResponseEntity<List<Application>> getAllApplicationsByUserId(@PathVariable String userId) {
		logger.info("GET request for /all/" + userId.toString());
		List<Application> applications = applicationRepo.findAllByUserId(userId);
				
		return ResponseEntity.ok(applications);
	}
	
	/**
	 * The deleteApplication method delete the application with the specified id in
	 * the path variable. 
	 * 
	 * @param id Application's ID
	 * @return ResponseEntity of Map stating if deleted is true
	 */
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
