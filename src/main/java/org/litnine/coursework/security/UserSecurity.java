package org.litnine.coursework.security;

import org.litnine.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {
    @Autowired
    UserService userService;

    public boolean hasUserId(String userId) {
        return userService.getActiveUser().getId().equals(userId);
    }
}