package com.fdmgroup.pawhero.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoleTest {

	Role actualRole;
	
	@Test
	void testRole_DefaultConstructor() {
		actualRole = new Role();
        actualRole.setName("Name");
        actualRole.setRoleId(123);
        assertEquals("Name", actualRole.getName());
        assertEquals(123, actualRole.getRoleId());
	}

	@Test
    public void testRole_ParameterizedConstructor() {
		actualRole = new Role(123, "Name");
        actualRole.setName("Name");
        actualRole.setRoleId(123);
        assertEquals("Name", actualRole.getName());
        assertEquals(123, actualRole.getRoleId());
	}
}
