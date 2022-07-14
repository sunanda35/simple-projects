package com.weatherapp.auth.config;


import com.weatherapp.auth.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    UserDetailRepository userDetailRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        final Map<String, Object> additionalInfo = new HashMap<>();
        com.weatherapp.auth.model.User userInfo =userDetailRepository.findByUsername(authentication.getName()).get();
        additionalInfo.put("id", userInfo.getId());
        additionalInfo.put("firstName", userInfo.getFirstName());
        additionalInfo.put("lastName", userInfo.getLastName());
        additionalInfo.put("email",userInfo.getEmail());
        additionalInfo.put("phone",userInfo.getPhone());
        additionalInfo.put("responseCode", "0");

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);

       return accessToken;

    }
}
