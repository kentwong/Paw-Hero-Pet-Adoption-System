package com.fdmgroup.pawhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
