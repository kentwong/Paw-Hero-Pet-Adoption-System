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
import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.repositories.PetRepository;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {

	@Mock
	private PetRepository mockPetRepo;
	
	private PetController petController;
	
	@BeforeEach
	void setUp() throws Exception {
		petController = new PetController(mockPetRepo);
	}

	@Test
	void that_getAllPets_returnsAllPets() {
		List<Pet> pets = Arrays.asList(new Pet());
		when(mockPetRepo.findAll()).thenReturn(pets);
		
		List<Pet> foundPets = petController.getAllPets();
		
		verify(mockPetRepo).findAll();
		assertEquals(pets, foundPets);
	}
	
	@Test
	void that_createPet_savePet_and_returnsPet() {
		Pet pet = new Pet();
		when(mockPetRepo.save(pet)).thenReturn(pet);
		
		Pet createdPet = petController.createPet(pet);
		
		verify(mockPetRepo).save(pet);
		assertEquals(pet, createdPet);
	}
	
	@Test
	void that_getPetById_findById_and_returnPet() {
		Pet pet = new Pet();
		Optional<Pet> ofResult = Optional.of(pet);
		int id = 1;
		when(mockPetRepo.findById(id)).thenReturn(ofResult);
		
		ResponseEntity<Pet> foundPet = petController.getPetById(id);
		
		verify(mockPetRepo).findById(id);
		assertEquals(200, foundPet.getStatusCodeValue());
		assertEquals(pet, foundPet.getBody());
	}
	
	@Test
	void that_getPetById_findById_and_returnResourceNotFoundException() {
		
		int id = 2;
		when(mockPetRepo.findById(id)).thenReturn(Optional.<Pet>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> petController.getPetById(id)); 
		assertEquals("Pet does not exist with id : 2", thrown.getMessage());
	}
	
	@Test
	void that_updatePet_findById_and_savePet_and_returnPet() {
		
		Pet pet = new Pet();
		Optional<Pet> ofResult = Optional.of(pet);
		int id = 3;
		when(mockPetRepo.findById(id)).thenReturn(ofResult);
	
		ResponseEntity<Pet> updatedPet = petController.updatePet(id, pet);
		
		verify(mockPetRepo).findById(id);
		verify(mockPetRepo).save(pet);
		assertEquals(200, updatedPet.getStatusCodeValue());
	}
	
	@Test
	void that_updatePet_findById_and_returnResourceNotFoundException() {
		int id = 4;
		Pet pet = new Pet();
		when(mockPetRepo.findById(id)).thenReturn(Optional.<Pet>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> petController.updatePet(id, pet)); 
		assertEquals("Pet does not exist with id : 4", thrown.getMessage());
	}
	
	@Test
	void that_deletePet_findById_and_deletePet_and_returnResponseEntity() {
		Pet pet = new Pet();
		Optional<Pet> ofResult = Optional.of(pet);
		int id = 5;
		when(mockPetRepo.findById(id)).thenReturn(ofResult);
		
		ResponseEntity<Map<String, Boolean>> deletedMessage = petController.deletePet(id);
		
		verify(mockPetRepo).findById(id);
		verify(mockPetRepo).delete(pet);
		
		assertEquals(200, deletedMessage.getStatusCodeValue());
		assertEquals("{deleted=true}", deletedMessage.getBody().toString());
	}
	
	@Test
	void that_deletePet_findById_and_returnResourceNotFoundException() {
		int id = 6;
		when(mockPetRepo.findById(id)).thenReturn(Optional.<Pet>empty());
		
		Throwable thrown = assertThrows(ResourceNotFoundException.class, () -> petController.deletePet(id)); 
		assertEquals("Pet does not exist with id : 6", thrown.getMessage());
	}

}
