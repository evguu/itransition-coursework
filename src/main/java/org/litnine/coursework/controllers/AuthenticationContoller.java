package org.litnine.coursework.controllers;

import org.litnine.coursework.domain.Role;
import org.litnine.coursework.domain.User;
import org.litnine.coursework.domain.UserDto;
import org.litnine.coursework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@Controller
public class AuthenticationContoller {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/register")
    public String register(Map<String, Object> model) {
        return "register_new";
    }

    @PostMapping("/register")
    public String addUser(UserDto userDto, Map<String, Object> model) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);

        if (violations.size() > 0) {
            model.put("message", "Either some field is not filled or email format is wrong.");
            return "register_new";
        }

        User userFromDb = userRepository.findByUsername(userDto.getUsername());

        if (userFromDb != null) {
            model.put("message", "Username is already taken!");
            return "register_new";
        }

        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) {
            model.put("message", "Passwords don't match.");
            return "register_new";
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setName(userDto.getName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setLanguage("en-EN");
        user.setIsDarkThemeEnabled(false);
        user.setEmail(userDto.getEmail());
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }

}
