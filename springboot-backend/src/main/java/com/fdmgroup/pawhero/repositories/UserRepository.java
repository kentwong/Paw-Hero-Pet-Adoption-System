package com.fdmgroup.pawhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User WHERE email_address=:email")
	User findByEmail(@Param("email") String email);
}
