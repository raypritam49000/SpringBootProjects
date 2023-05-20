package com.criteria.query.rest.api.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.criteria.query.rest.api.dto.UserDTO;
import com.criteria.query.rest.api.ultility.jwt.JwtUtility;

public class JwtAuthenticationFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		try {

			String authHeader = request.getHeader("Authorization");

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}
			
			final String token = authHeader.substring(7);
			
			if (token != null && JwtUtility.verifyToken(token)) {
				UserDTO user = JwtUtility.getUserDtoFromToken(token);
				request.setAttribute("user", user);
			}
			else {
				throw new ServletException("Token is invalid!!!");
			}

			filterChain.doFilter(req, res);
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
	}

}
