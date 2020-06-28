package com.twoplus.apartfriend.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.http.server.ServletServerHttpResponse;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import org.springframework.security.web.savedrequest.RequestCache;

import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.twoplus.apartfriend.dto.JSONResult2;


@Component
public class CustomUrlAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	protected final Log logger = LogFactory.getLog(this.getClass());

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,

			Authentication authentication) throws ServletException, IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest != null) {

			requestCache.removeRequest(request, response);

			clearAuthenticationAttributes(request);

		}

		String accept = request.getHeader("accept");

		SecurityUser securityUser = null;

		if (SecurityContextHolder.getContext().getAuthentication() != null) {

			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal != null && principal instanceof UserDetails) {

				securityUser = (SecurityUser) principal;

			}

		}

		// 응답요청이 JSON 아닐때, / 로 보낸다.
		if( accept == null || accept.matches( ".*application/json.*" ) == false ) {
			
			System.out.println("security userName: "+securityUser.getId());
            request.getSession(true).setAttribute("loginNow", true);
            if(!securityUser.getId().equals("admin")) {
            	getRedirectStrategy().sendRedirect( request, response, "/index" );
            } else {
            	getRedirectStrategy().sendRedirect( request, response, "/admin/" );
            }
            
            return;
         }
         
         MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
         MediaType jsonMimeType = MediaType.APPLICATION_JSON;
        
         JSONResult2 jsonResult = JSONResult2.success(securityUser);
         if( jsonConverter.canWrite( jsonResult.getClass(), jsonMimeType ) ) {
             jsonConverter.write( jsonResult, jsonMimeType, new ServletServerHttpResponse( response ) );
         }

	}

	public void setRequestCache(RequestCache requestCache) {

		this.requestCache = requestCache;

	}

}