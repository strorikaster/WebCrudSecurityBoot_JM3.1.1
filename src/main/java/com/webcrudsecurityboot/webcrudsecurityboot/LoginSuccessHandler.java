package com.webcrudsecurityboot.webcrudsecurityboot;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        for (String role : roles) {
            System.out.println(role);
        }

        if (roles.size() > 1) {
            if(roles.contains("ADMIN") && roles.contains("VIP")) {
                httpServletResponse.sendRedirect("/vip");
            }
            if(roles.contains("ADMIN") && roles.contains("USER")) {
                httpServletResponse.sendRedirect("/user/lk");
            }
            if(roles.contains("VIP") && roles.contains("USER")) {
                httpServletResponse.sendRedirect("/user/lk");
            }
        } else {
            if (roles.contains("ADMIN")) {
                httpServletResponse.sendRedirect("/admin");
            } else if (roles.contains("VIP")) {
                httpServletResponse.sendRedirect("/vip");
            } else {
                httpServletResponse.sendRedirect("/user/lk");
            }
        }
    }
}
