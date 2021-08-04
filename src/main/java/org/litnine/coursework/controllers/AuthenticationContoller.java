package org.litnine.coursework.controllers;

import org.litnine.coursework.domain.User;
import org.litnine.coursework.domain.UserDto;
import org.litnine.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.*;
import java.util.Map;

@Controller
public class AuthenticationContoller {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Map<String, Object> model) {
        return "register_new";
    }

    @PostMapping("/register")
    public String addUser(@Valid UserDto userDto, BindingResult bindingResult, Map<String, Object> model) {
        if (bindingResult.hasErrors()) {
            model.put("message", "Either some field is not filled or email format is wrong.");
            return "register_new";
        }

        User userFromDb = userService.getUserByUsername(userDto.getUsername());

        if (userFromDb != null) {
            model.put("message", "Username is already taken!");
            return "register_new";
        }

        userService.createUser(userDto);

        return "redirect:/login";
    }

}
