package com.fdmgroup.pawhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
