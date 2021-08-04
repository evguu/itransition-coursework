package org.litnine.coursework.controllers;

import org.litnine.coursework.domain.UserDto;
import org.litnine.coursework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.*;
import java.util.Locale;
import java.util.Map;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/register")
    public String register(Map<String, Object> model) {
        return "register_new";
    }

    @PostMapping("/register")
    public String addUser(@Valid UserDto userDto, BindingResult bindingResult, Map<String, Object> model, Locale locale) {
        if (bindingResult.hasErrors()) {
            model.put("message", messageSource.getMessage("register.invalid_email", null, locale));
            return "register_new";
        }

        if (userService.hasUserWithUsername(userDto.getUsername())) {
            model.put("message",  messageSource.getMessage("register.username_already_taken", null, locale));
            return "register_new";
        }

        userService.createUser(userDto);
        return "redirect:/login";
    }

}
