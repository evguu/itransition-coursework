package org.litnine.coursework.services;

import org.litnine.coursework.domain.*;
import org.litnine.coursework.repositories.UserRepository;
import org.litnine.coursework.services.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class GithubUserService extends DefaultOAuth2UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        try {
            return processOAuth2User(super.loadUser(userRequest));
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2User oAuth2User) {
        UserInfo userInfo = new GithubUserInfo(oAuth2User.getAttributes());
        Utils.processUserInfo(userInfo, userRepository);
        return oAuth2User;
    }
}
