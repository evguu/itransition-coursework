package org.litnine.coursework.controllers;

import lombok.SneakyThrows;
import org.litnine.coursework.domain.Collection;
import org.litnine.coursework.domain.User;
import org.litnine.coursework.repositories.CollectionRepository;
import org.litnine.coursework.repositories.UserRepository;
import org.litnine.coursework.services.UserService;
import org.litnine.coursework.services.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Field;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@Controller
public class TestDataController {

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    UserService userService;

    @SneakyThrows
    @GetMapping("/gentest")
    public String gentest() {
        Collection collection = new Collection();
        collection.setTitle("Test collection");

        collection.setUser(userService.getActiveUser());
        collectionRepository.save(collection);

        return "redirect:";
    }
}
