package com.fdmgroup.pawhero.service;

import com.fdmgroup.pawhero.model.User;
import com.fdmgroup.pawhero.web.dto.UserRegistrationDto;

public interface IUserService {

	User save(UserRegistrationDto registrationDto);
}
