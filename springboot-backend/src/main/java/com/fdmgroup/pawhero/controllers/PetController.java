package com.fdmgroup.pawhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.repositories.PetRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/pawhero/api/v1/")
public class PetController {

	@Autowired
	private PetRepository petRepository;
	
	@GetMapping("/pets")
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
	
	@PostMapping("/pets")
	public Pet createPet(@RequestBody Pet pet) {
		return petRepository.save(pet);
	}
}
