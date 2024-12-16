package com.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
public class CustomUserDetails implements UserDetails {
	
	private String userName,password;
	private List<GrantedAuthority> roles = new ArrayList<>();
	
	public CustomUserDetails(UserModel user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		String[] roles = user.getRoles().split(",");
		for(int i=0;i<roles.length;i++) {
			this.roles.add(new SimpleGrantedAuthority(roles[i]));
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
