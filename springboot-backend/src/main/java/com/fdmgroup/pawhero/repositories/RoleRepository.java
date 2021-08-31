package com.fdmgroup.pawhero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.pawhero.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
