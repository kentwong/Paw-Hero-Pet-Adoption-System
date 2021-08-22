package com.fdmgroup.pawhero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.pawhero.model.Pet;
import com.fdmgroup.pawhero.repositories.PetRepository;

@RestController
@RequestMapping("/api/")
public class PetController {

	@Autowired
	private PetRepository petRepository;
	
	@GetMapping("/pets")
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
}
