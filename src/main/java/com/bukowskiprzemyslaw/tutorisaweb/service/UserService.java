package com.bukowskiprzemyslaw.tutorisaweb.service;

import com.bukowskiprzemyslaw.tutorisaweb.entity.User;
import com.bukowskiprzemyslaw.tutorisaweb.web.dto.UserRegistrationDto;

public interface UserService {

    User save(UserRegistrationDto registrationDto);
}
