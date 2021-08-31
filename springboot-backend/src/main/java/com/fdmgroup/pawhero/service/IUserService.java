package com.fdmgroup.pawhero.service;

import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.web.dto.UserRegistrationDto;

public interface IUserService {

	User save(UserRegistrationDto registrationDto);
}
