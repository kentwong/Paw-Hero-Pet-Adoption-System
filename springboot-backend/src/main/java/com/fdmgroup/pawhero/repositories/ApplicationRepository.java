package com.fdmgroup.pawhero.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	/**
	 * The findAllByUserId method returns all applications with user id
	 * specified in the parameter
	 * 
	 * @param userId User's ID
	 * @return List of Application objects with the same user id
	 */
	@Query("FROM Application WHERE user_id=:userId")
	List<Application> findAllByUserId(@Param("userId") String userId);
}
