package org.litnine.coursework.controllers;

import lombok.SneakyThrows;
import org.litnine.coursework.domain.Collection;
import org.litnine.coursework.repositories.CollectionRepository;
import org.litnine.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
