package com.fdmgroup.pawhero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@PutMapping("/pets/{id}")
	public ResponseEntity<Pet> updatePet(@PathVariable Integer id, @RequestBody Pet petUpdates) {
		Pet pet = petRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet does not exist with id : " + id));
		
		pet.setAdoptionFee(petUpdates.getAdoptionFee());
		pet.setAge(petUpdates.getAge());
		pet.setBreed(petUpdates.getBreed());
		pet.setDescription(petUpdates.getDescription());
		pet.setImageUrl(petUpdates.getImageUrl());
		pet.setLocation(petUpdates.getLocation());
		pet.setName(petUpdates.getName());
		pet.setSex(petUpdates.getSex());
		pet.setType(petUpdates.getType());
		
		Pet updatedPet = petRepo.save(pet);
		return ResponseEntity.ok(updatedPet);
	}
	
	@DeleteMapping("/pets/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePet(@PathVariable Integer id) {
		Pet pet = petRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet does not exist with id : " + id));
		
		petRepo.delete(pet);
	
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
	
	
}
