package ua.gudlana.StadyGudLana.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServerException{
        response.setStatus((HttpServletResponse.SC_OK));

        for(GrantedAuthority auth : authentication.getAuthorities()){
            if("ADMIN".equals(auth.getAuthority())){
                response.sendRedirect("/dashboard");
            }
        }
    }
}
