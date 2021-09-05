package com.fdmgroup.pawhero.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.fdmgroup.pawhero.exception.ResourceNotFoundException;
import com.fdmgroup.pawhero.model.Application;
import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.repositories.ApplicationRepository;

@ExtendWith(MockitoExtension.class)
class ApplicationControllerTest {

	@Mock
	ApplicationRepository mockAppRepo;
	
	ApplicationController appController;
	
	@BeforeEach
	void setUp() throws Exception {
		appController = new ApplicationController(mockAppRepo);
	}

	@Test
	void that_getAllApplications_findAll_and_retunrsAllApplications() {
		List<Application> applications = Arrays.asList(new Application());
		when(mockAppRepo.findAll()).thenReturn(applications);
		
		List<Application> foundApps = appController.getAllApplications();
		
		verify(mockAppRepo).findAll();
		assertEquals(applications, foundApps);
	}
	
	@Test
	void that_createApplication_saveApplication_and_returnsApplication() {
		Application app = new Application();
		when(mockAppRepo.save(app)).thenReturn(app);
		
		Application createdApp = appController.createApplication(app);
		
		verify(mockAppRepo).save(app);
		assertEquals(app, createdApp);
	}
	
	@Test
	void that_updateApplication_findById_and_saveApplication_and_returnApplication() {
		
		Application app = new Application();
		Optional<Application> ofResult = Optional.of(app);
		int id = 1;
		when(mockAppRepo.findById(id)).thenReturn(ofResult);
	
		ResponseEntity<Application> updatedApp = appController.updateApplication(id, app);
		
		verify(mockAppRepo).findById(id);
		verify(mockAppRepo).save(app);
		assertEquals(200, updatedApp.getStatusCodeValue());
	}
	
	@Test
	void that_updateApplication_findById_and_returnResourceNotFoundException() {
		int id = 2;
		Application app = new Application();
		when(mockAppRepo.findById(id)).thenReturn(Optional.<Application>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> appController.updateApplication(id, app)); 
		assertEquals("Application does not exist with id : 2", thrown.getMessage());
	}
	
	@Test
	void that_getAllApplicationsByUserId_findAllByUserId_and_returns_ApplicationsList() {
		String id = "3";
		List<Application> applications = Arrays.asList(new Application());
		when(mockAppRepo.findAllByUserId(id)).thenReturn(applications);
		
		ResponseEntity<List<Application>> foundApp = appController.getAllApplicationsByUserId(id);
		
		verify(mockAppRepo).findAllByUserId(id);
		assertEquals(200, foundApp.getStatusCodeValue());
		assertEquals(applications, foundApp.getBody());
	}
	
	@Test
	void that_deleteApplication_findById_and_deleteApplication_and_returnResponseEntity() {
		Application app = new Application();
		Optional<Application> ofResult = Optional.of(app);
		int id = 5;
		when(mockAppRepo.findById(id)).thenReturn(ofResult);
		
		ResponseEntity<Map<String, Boolean>> deletedMessage = appController.deleteApplication(id);
		
		verify(mockAppRepo).findById(id);
		verify(mockAppRepo).delete(app);
		
		assertEquals(200, deletedMessage.getStatusCodeValue());
		assertEquals("{deleted=true}", deletedMessage.getBody().toString());
	}
	
	@Test
	void that_deleteApplication_findById_and_returnResourceNotFoundException() {
		int id = 6;
		when(mockAppRepo.findById(id)).thenReturn(Optional.<Application>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> appController.deleteApplication(id)); 
		assertEquals("Application does not exist with id : 6", thrown.getMessage());
	}

}
