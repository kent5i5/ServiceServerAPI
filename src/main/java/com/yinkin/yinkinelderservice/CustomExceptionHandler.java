package com.yinkin.yinkinelderservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomExceptionHandler implements AccessDeniedHandler{
    @Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) 
	    throws IOException, ServletException {
	    response.sendRedirect("/access-denied.html");
	}
}
