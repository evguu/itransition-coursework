package org.litnine.coursework.services;

import org.litnine.coursework.domain.User;
import org.litnine.coursework.domain.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void createUser(UserDto userDto);

    User getUserByUsername(String username);
}

