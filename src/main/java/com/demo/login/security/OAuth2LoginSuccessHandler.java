package com.demo.login.security;

import com.demo.login.user.User;
import com.demo.login.user.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private UserService userService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException, ServletException {

        CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
        String email = oauthUser.getEmail();
        User user = userService.findByEmail(email);
        String name = oauthUser.getName();
        if ( user == null ){
            userService.createNewUserAfterOAuthLoginSuccess(email, name, AuthenticationProvider.GOOGLE);

        }else{
            userService.updateCustomerAfterOAuthLoginSuccess(user, name, AuthenticationProvider.LOCAL);
        }
        System.out.println("Customer's email: " + email);
        super.onAuthenticationSuccess(request, response, chain, authentication);
    }
}
