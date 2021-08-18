package org.litnine.coursework.services;

import org.litnine.coursework.domain.GoogleUserInfo;
import org.litnine.coursework.domain.UserInfo;
import org.litnine.coursework.repositories.UserRepository;
import org.litnine.coursework.services.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class GoogleUserService extends OidcUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        try {
            return processOidcUser(super.loadUser(userRequest));
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OidcUser processOidcUser(OidcUser oidcUser) {
        UserInfo userInfo = new GoogleUserInfo(oidcUser.getAttributes());
        Utils.processUserInfo(userInfo, userRepository);
        return oidcUser;
    }

}

