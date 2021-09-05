package com.fdmgroup.pawhero.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PetTest {

	Pet actualPet;
	
	@Test
	void testPet_DefaultConstructor() {
		actualPet = new Pet();
        actualPet.setAdoptionFee("Adoption Fee");
        actualPet.setAge("Age");
        actualPet.setBreed("Breed");
        actualPet.setDescription("The characteristics of someone or something");
        actualPet.setImageUrl("https://example.org/example");
        actualPet.setLocation("Location");
        actualPet.setName("Bella");
        actualPet.setPetId(123);
        actualPet.setSex("Sex");
        actualPet.setType("Type");
        assertEquals("Adoption Fee", actualPet.getAdoptionFee());
        assertEquals("Age", actualPet.getAge());
        assertEquals("Breed", actualPet.getBreed());
        assertEquals("The characteristics of someone or something", actualPet.getDescription());
        assertEquals("https://example.org/example", actualPet.getImageUrl());
        assertEquals("Location", actualPet.getLocation());
        assertEquals("Bella", actualPet.getName());
        assertEquals(123, actualPet.getPetId());
        assertEquals("Sex", actualPet.getSex());
        assertEquals("Type", actualPet.getType());
	}
	
	@Test
    public void testPet_ParameterizedConstructor() {
		actualPet = new Pet("Type", "Bella", "Breed", "Age", "Sex", "Location", "Adoption Fee", "The characteristics of someone or something", "https://example.org/example");
        actualPet.setAdoptionFee("Adoption Fee");
        actualPet.setAge("Age");
        actualPet.setBreed("Breed");
        actualPet.setDescription("The characteristics of someone or something");
        actualPet.setImageUrl("https://example.org/example");
        actualPet.setLocation("Location");
        actualPet.setName("Bella");
        actualPet.setPetId(123);
        actualPet.setSex("Sex");
        actualPet.setType("Type");
        assertEquals("Adoption Fee", actualPet.getAdoptionFee());
        assertEquals("Age", actualPet.getAge());
        assertEquals("Breed", actualPet.getBreed());
        assertEquals("The characteristics of someone or something", actualPet.getDescription());
        assertEquals("https://example.org/example", actualPet.getImageUrl());
        assertEquals("Location", actualPet.getLocation());
        assertEquals("Bella", actualPet.getName());
        assertEquals(123, actualPet.getPetId());
        assertEquals("Sex", actualPet.getSex());
        assertEquals("Type", actualPet.getType());
	}
}
