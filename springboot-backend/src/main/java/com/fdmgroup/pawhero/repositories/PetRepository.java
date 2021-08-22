package com.fdmgroup.pawhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{

}
