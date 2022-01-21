package com.squadio.accountstatements.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthEntryPointFilter implements AuthenticationEntryPoint {
    private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointFilter.class);

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException, IOException {
        logger.error("Unauthorized error: {}", e.getMessage());
        final String expired = (String) httpServletRequest.getAttribute("expired");
        logger.info("AuthEntryPointJwt: {}", expired);
        if (expired != null) {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, expired);
        } else {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token required for authorization");
        }
    }


    private String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
