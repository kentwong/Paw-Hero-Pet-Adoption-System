package com.fdmgroup.pawhero.controllers;

import java.util.List;
import java.util.Optional;

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
import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.repositories.PetRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/api/v1/")
public class PetController {

	@Autowired
	private PetRepository petRepo;
	
	@GetMapping("/pets")
	public List<Pet> getAllPets(){
		return petRepo.findAll();
	}
	
	@PostMapping("/pets")
	public Pet createPet(@RequestBody Pet pet) {
		return petRepo.save(pet);
	}
	
	@GetMapping("/pets/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable Integer id) {
		Pet pet = petRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet does not exist with id : " + id));
		
		return ResponseEntity.ok(pet);
	}
	
	
}
