package org.litnine.coursework.services;

import lombok.SneakyThrows;
import org.litnine.coursework.domain.User;
import org.litnine.coursework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @SneakyThrows
    public User getActiveUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Field field = authentication.getClass().getDeclaredField("authorizedClientRegistrationId");
        field.setAccessible(true);
        String id = field.get(authentication) + "-" + authentication.getName();
        return userRepository.getById(id);
    }
}
