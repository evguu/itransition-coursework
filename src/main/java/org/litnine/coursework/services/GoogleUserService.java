package org.litnine.coursework.services;

import org.litnine.coursework.domain.GoogleUserInfo;
import org.litnine.coursework.domain.Role;
import org.litnine.coursework.domain.User;
import org.litnine.coursework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class GoogleUserService extends OidcUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);

        try {
            return processOidcUser(userRequest, oidcUser);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {
        GoogleUserInfo googleUserInfo = new GoogleUserInfo(oidcUser.getAttributes());

        System.out.println("was allowed to process some tasty data");

        Optional<User> userOptional = userRepository.findByEmail(googleUserInfo.getEmail());
        if (userOptional.isEmpty()) {
            User user = new User();
            user.setEmail(googleUserInfo.getEmail());
            user.setName(googleUserInfo.getName());
            user.setLanguage("en-EN");
            user.setIsDarkThemeEnabled(false);
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
        }

        return oidcUser;
    }

}

