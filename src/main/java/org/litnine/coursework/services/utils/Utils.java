package org.litnine.coursework.services.utils;

import lombok.SneakyThrows;
import org.litnine.coursework.domain.Role;
import org.litnine.coursework.domain.User;
import org.litnine.coursework.domain.UserInfo;
import org.litnine.coursework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Optional;

public class Utils {

    public static void processUserInfo(UserInfo userInfo, UserRepository userRepository) {
        if (userRepository.findById(userInfo.getId()).isPresent()) return;
        User user = mapUserInfoToUser(userInfo, new User());
        setDefaultSettings(user);
        userRepository.save(user);
    }

    private static User mapUserInfoToUser(UserInfo userInfo, User user){
        user.setId(userInfo.getId());
        user.setName(userInfo.getName());
        return user;
    }

    private static void setDefaultSettings(User user) {
        user.setLanguage("en-EN");
        user.setIsDarkThemeEnabled(false);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
    }
}
