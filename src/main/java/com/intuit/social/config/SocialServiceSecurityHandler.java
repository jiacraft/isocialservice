package com.intuit.social.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SocialServiceSecurityHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private static final String DEFAULT_API = "/feed";

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		// to make default landing on /feed 
		setDefaultTargetUrl(DEFAULT_API);		
		super.onAuthenticationSuccess(request, response, authentication);		
	}

}
