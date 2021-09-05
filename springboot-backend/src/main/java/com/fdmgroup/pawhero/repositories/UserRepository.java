package com.fdmgroup.pawhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * The findByEmail method returns the user with email address
	 * specified in the parameter
	 * 
	 * @param email User's email
	 * @return User
	 */
	@Query("FROM User WHERE email_address=:email")
	User findByEmail(@Param("email") String email);
}
