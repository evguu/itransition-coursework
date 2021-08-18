package org.litnine.coursework.services;

import org.litnine.coursework.domain.GoogleUserInfo;
import org.litnine.coursework.domain.Role;
import org.litnine.coursework.domain.User;
import org.litnine.coursework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class GithubUserService extends DefaultOAuth2UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        GoogleUserInfo googleUserInfo = GoogleUserInfo.fromGithubAttributes(oAuth2User.getAttributes());

        System.out.println("GHub allowed to process some tasty data!!");

        Optional<User> userOptional = userRepository.findById(googleUserInfo.getId());
        if (userOptional.isEmpty()) {
            User user = new User();
            user.setId(googleUserInfo.getId());
            user.setName(googleUserInfo.getName());
            user.setLanguage("en-EN");
            user.setIsDarkThemeEnabled(false);
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
        }

        return oAuth2User;
    }
}
