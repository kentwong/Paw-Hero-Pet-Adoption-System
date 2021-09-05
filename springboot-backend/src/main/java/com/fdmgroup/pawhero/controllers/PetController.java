package com.fdmgroup.pawhero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * The PetController class controls the flow of data into model object. The 
 * rest API requests available include getAllPets(), createPets(),
 * updatePets(), getPetById(), updatePet() and deletePet(). 
 * 
 * @author kentwong
 *
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/api/v1/")
public class PetController {

	private static Logger logger = LogManager.getLogger(PetController.class);
	
	@Autowired
	private PetRepository petRepo;
	
	public PetController(PetRepository petRepo) {
		super();
		this.petRepo = petRepo;
	}

	/**
	 * The getAllPets method return the list of all Pet objects.
	 * 
	 * @return List of Pet Objects
	 */
	@GetMapping("/pets")
	public List<Pet> getAllPets(){
		logger.info("GET request for /pets");
		return petRepo.findAll();
	}
	
	/**
	 * The createPet method will save the new Pet in the database
	 * 
	 * @param pet New Pet's object
	 * @return Pet object
	 */
	@PostMapping("/pets")
	public Pet createPet(@RequestBody Pet pet) {
		logger.info("POST request for /pets");
		return petRepo.save(pet);
	}
	
	/**
	 * The getPetById method returns pet with the specified
	 * ID in path variable. 
	 * 
	 * @param id Pet's ID
	 * @return ResponseEntity of Pet
	 */
	@GetMapping("/pets/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable Integer id) {
		logger.info("GET request for /pets/" + id.toString());
		Pet pet = petRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet does not exist with id : " + id));
		
		return ResponseEntity.ok(pet);
	}
	
	/**
	 * The updatePet method will update the all properties of the pet with ID
	 * specified in path variable. 
	 * 
	 * @param id Pet's ID
	 * @param petUpdates Updated pet object with new details
	 * @return ResponseEntity of Pet
	 */
	@PutMapping("/pets/{id}")
	public ResponseEntity<Pet> updatePet(@PathVariable Integer id, @RequestBody Pet petUpdates) {
		logger.info("PUT request for /pets/" + id.toString());
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
	
	/**
	 * The deletePet method delete the pet with the specified id in
	 * the path variable. 
	 * 
	 * @param id Pet's ID
	 * @return ResponseEntity of Map stating if deleted is true
	 */
	@DeleteMapping("/pets/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePet(@PathVariable Integer id) {
		logger.info("DELETE request for /pets/" + id.toString());
		Pet pet = petRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pet does not exist with id : " + id));
		
		petRepo.delete(pet);
	
		Map<String, Boolean> res = new HashMap<>();
		res.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(res);
	}
}
