package com.jwt.rest.api.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
	private static final Logger LOGGER = LogManager.getLogger(JwtTokenFilter.class);

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    	LOGGER.info("@@@ [Inside doFilterInternal] " + request.getRequestURL());
    	        String header = request.getHeader(AUTHORIZATION_HEADER);
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            String token = header.substring(TOKEN_PREFIX.length());
            try {
////                JwtUtils.validateToken(token);
                chain.doFilter(request, response);
            } catch (Exception ex) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.sendError(401, ex.getMessage());
            }
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.sendError(401, "UNAUTHORIZED");
        }
    }
}
