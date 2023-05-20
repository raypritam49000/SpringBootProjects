package com.jwt.rest.api.intercepter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.rest.api.dto.UserDto;
import com.jwt.rest.api.utility.JwtUtils;

@Component
public class UserSecurityInterceptor implements HandlerInterceptor {

	private static final Logger LOGGER = LogManager.getLogger(UserSecurityInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("@@@ [Inside PRE Handle Interceptor] " + request.getRequestURL());
		try {

			String authHeader = request.getHeader("Authorization");

			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid Authorization header");
			}

			final String token = authHeader.substring(7);

			if (token != null && JwtUtils.verifyToken(token)) {
				UserDto user = JwtUtils.userFromToken(token);
				request.setAttribute("user", user);
			} else {
				throw new ServletException("Token is invalid!!!");
			}
		} catch (Exception e) {
			LOGGER.error("@@@ Error : {}",e.getMessage());
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		LOGGER.info("@@@ [Inside POST Handle Interceptor] " + request.getRequestURL());

	}

}
