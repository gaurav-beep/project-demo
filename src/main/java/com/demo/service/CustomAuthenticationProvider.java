package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		System.out.println("encoded password : "+passwordEncoder.encode(password));
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

		if (new BCryptPasswordEncoder().matches(password, userDetails.getPassword())) {
			return new UsernamePasswordAuthenticationToken(username, password, userDetails.getAuthorities());
		} else {
			throw new BadCredentialsException("Invalid username or password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
